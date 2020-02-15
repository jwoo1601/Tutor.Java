package examples.java.chapter2;

// 기본�?으로 interface 는 abstract class
// 1. member field (variable) 가 존재하지 않�?�
// 2. member method 만 존재함
// 3. member method 가 전부 public abstract
// 4. modifier X
// 5. 기본�?�?� method body 제공 가능 (default 를 붙여야�?�)
public interface Equippable {
	void equip();
	void unequip();
	default boolean isEquipped() {
		return false;
	}
}
