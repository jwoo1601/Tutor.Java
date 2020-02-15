package examples.java.chapter2;

// extends : 확장한다 (무조건 �?�래스 하나만)
// implements: 구현한다 (�?�터페�?�스 여러개�?�)
// multiple inheritance (다중 �?�?): Super �?�래스가 여러개

// 다중�?�?�?� 받�?�때는 �?�터페�?�스만 가능하다
// �?�터페�?�스만 다중�?�?�?� 가능한 �?�유
// �?�터페�?�스는 멤버로 public abstract method 만 가질 수 있�?�. (즉, field 가 나올 수 없�?�)
// 따�?�서, 다중�?�?�?� 받�?� 때 �?�?받는 �? Super class �?� member field �?�름�?� 겹�?서 충�?��?� 발�?하는 경우
// (예를들어 C 가 A 와 B 를 �?�시�? �?�?받는다 가정할 때, A 와 B 둘다 member field 로 d �?�는 멤버를 가지고 있�?� 경우, C �?서는 A �?� d 와 B �?� d를 둘다 물려받기 때문�?
//  d 를 사용하게�?�면 누구로부터 물려받�?� d 를 가리키게 �?�는지 모호함�?� 발�?하게 �?�.)
// �?한, abstract method 가 아닌 �?�반 method 를 물려받는 경우�?�?� 마찬가지로 A 와 B 둘다 member method 로 abstract 가 아닌 f �?�는 method 가 있�?� 경우,
// C �?서는 �? A 와 B �?� f 를 다 물려받기 때문�? C 를 통해서 f 를 호출하게�?�면 물려받�?� f 는 누구�?� f �?�지 �?별하기가 모호해�?.
// �?�를 해결하기 위해 interface 가 등장.

// �?�터페�?�스는 멤버 필드를 가짌 수 없고 무조건 abstract method 만 가질 수 있기�? C �?�는 �?�래스�?서 A 와 B �?�는 �?�터페�?�스로부터 �?�? 물려받�?� method 들�?� �?�름�?� 겹치�?��?��?�
// 실제 구현 (method �?� body) 는 하나만 존재하기 때문�? 모호함�?� 발�?하지 않�?�.
// 따�?�서, Java �?서는 multiple inheritance 를 interface 를 통한 경우만 허용함.
public abstract class Weapon extends GameItem implements Equippable, Droppable {
	private String itemName;
	
	// Weapon �?체�?� abstract method
	public abstract int getAttackDamage();

	@Override
	// Equippable �?�터페�?�스로부터 물려받�?� method
	public String getItemName() {
		return itemName;
	}
	
	@Override
	// Droppable �?�터페�?�스로부터 물려받�?� method
	public int getDropPosition() {
		return 0;
	}
}