package examples.java.chapter2;

// abstract class 가 아닌 �?�래스를 concrete class
public class Spear extends Weapon {
	public int getAttackDamage() {
		return 300;
	}

	public String getItemName() {
		return "Spear";
	}

	@Override
	public void equip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unequip() {
		// TODO Auto-generated method stub
		
	}
}
