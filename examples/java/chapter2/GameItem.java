package examples.java.chapter2;

public abstract class GameItem {
	protected int slotNumber;
	
	public abstract String getItemName(); // public abstract
	
	public int getSlotNumber() {
		return slotNumber;
	}
}
