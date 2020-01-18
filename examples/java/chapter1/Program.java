package examples.java.chapter1;

// PlayerInfo 클래스 선언
class PlayerInfo {
	private String playerName;
	private int playtime = 10;
	
	// Constructor
	public PlayerInfo(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setPlayerName(String newName) {
		this.playerName = newName;
	}
	
	public int getPlaytime() {
		return this.playtime;
	}
	
	public void setPlaytime(int newPlaytime) {
		this.playtime = newPlaytime;
	}
}

public class Program {
	public static void main(String[] args) {
		// Instantiation: steve 라는 PlayerInfo 타입의 object 를 생성함.
		PlayerInfo steve = new PlayerInfo("Steve");
		// Instantiation: brad 라는 PlayerInfo 타입의 object 를 생성함.
		PlayerInfo brad = new PlayerInfo("Brad");
		
		// steve 의  playerName field 값을 가져오는 getter
		System.out.println(steve.getPlayerName()); // Steve
		// brad 의 playerName field 값을 가져오는 getter
		System.out.println(brad.getPlayerName()); // Brad
		
		brad.setPlayerName("Daniel"); // brad 오브젝트의 playerName 필드 값을 Daniel 로 변경함
		System.out.println(brad.getPlayerName()); // Daniel
		// steve 오브젝트는 brad 오브젝트와 완전히 독립되어 있으므로 brad 오브젝트의 변경사항은 steve 오브젝트에 영향을 주지 않음.
		System.out.println(steve.getPlayerName()); // Steve
	}
}
