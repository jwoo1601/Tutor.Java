package examples.java.chapter1;

public class Player {
	
	private int hp;
	private String name;
	private int level;
	private int attackDamage;
	private int armour;
	
	private boolean hasUnlockedSpecialItem;
	
	public Player(int hp, String name, int attackDamage, int armour) {
		this.hp = Math.min(Math.max(0, hp), 100);
		this.name = name;
		this.level = 1;
		this.attackDamage = Math.max(0, attackDamage);
		this.armour = Math.max(0, armour);
		
		this.hasUnlockedSpecialItem = false;
	}
	
	private int getRandomAttackDamageFactor() {
		return hasUnlockedSpecialItem? (int)(Math.random() * 40.) : 0;
	}
	
	public void takeDamage(int incomingDamage) {
		hp = Math.max(0, hp + Math.min(0, armour - incomingDamage));
	}
	
	public void attack(Player target) {
		target.takeDamage(attackDamage + getRandomAttackDamageFactor());
	}
	
	public int getHP() {
		return hp;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getAttackDamage() {
		return attackDamage;
	}
	
	public int getArmour() {
		return armour;
	}
	
	public boolean isAlive() {
		return hp > 0;
	}
	
	public boolean unlockedSpecialItem() {
		return hasUnlockedSpecialItem;
	}
	
	public void unlockSpecialItem() {
		if (!hasUnlockedSpecialItem) {
			hasUnlockedSpecialItem = true;
		}
	}
	
	public void unlockSpecialItemByChance(int percentage) {
		int clampedPercentage = Math.min(Math.max(0, percentage), 100);
		
		if (clampedPercentage > 0) {
			hasUnlockedSpecialItem = Math.min((int)(Math.random() * 100.) + 1, 100) <= percentage;
		}
	}
	
	private static void printPlayerCombatStats(Player p1, Player p2, String mark) {
		System.out.println("  " + p1.name + "(" + p1.hp + ")" + "        VS    " + p2.name + "(" + p2.hp + ")");
		
		String p1HpStat = p1.getPlayerHpStatString();
		String p2HpStat = p2.getPlayerHpStatString();
		System.out.println("" + p1HpStat + "    " + mark + "    " + p2HpStat);
	}
	
	private String getPlayerHpStatString() {
		int playerNumHpBars = (int)(hp / 100.f * 10.f);
		return "0 " + "=".repeat(playerNumHpBars) + "-".repeat(10 - playerNumHpBars)  + " 100";
	}
	
	public Player doFight(Player enemy) {
		int numRounds = 0;
		

			try {
				Thread.sleep(2000);
				
				while (this.isAlive() && enemy.isAlive()) {
				if (!this.unlockedSpecialItem()) {
					this.unlockSpecialItemByChance((int)(Math.random() * 100.));
					
					if (this.unlockedSpecialItem()) {
						System.out.println();
						System.out.println(this.name + " has unlocked a special item!");
						System.out.println();
					}
				}
				if (!enemy.unlockedSpecialItem()) {
					enemy.unlockSpecialItemByChance((int)(Math.random() * 100.));
					
					if (enemy.unlockedSpecialItem()) {
						System.out.println();
						System.out.println(enemy.name + " has unlocked a special item!");
						System.out.println();
					}
				}
				
				System.out.println();
				System.out.println("Round " + numRounds++);
				printPlayerCombatStats(this, enemy, ">");
				this.attack(enemy);
				
				Thread.sleep(1000);
				
				System.out.println();
				printPlayerCombatStats(this, enemy, "<");
				enemy.attack(this);
				
				Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		Player winner = this.isAlive()? this : enemy;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Final Result:");
		printPlayerCombatStats(this, enemy, winner.equals(this)? ">" : "<");
		
		System.out.println();
		System.out.println("Fight done!\nWinner: " + winner.name);
		
		return winner;
	}
}