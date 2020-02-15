package examples.java.chapter1;

// public, protected, private, default  =>  Member Access Level Modifier (멤버 접근 수준 지정자)

// Overriding vs Shadowing
public class GameObject {
	private float x, y, z;
	private float mass; // private
	
	protected float rotation; // protected
	
	int a; // default

	public String getName() {
		return "GameObject";
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public float getZ() {
		return z;
	}
	
	public float mass() {
		return mass;
	}
	
	protected void setRotation() { }
}

class Item extends GameObject {
	
	@Override // Annotation
	public String getName() {
		return "Item";
	}
	
	@Override
	public float getX() {
		return 5;
	}
}

class Test {
	public static void main(String[] arsgs) {
		Item knife = new Item();
		System.out.println(knife.getName()); // "GameObject"
		
		if (knife.getName() == "Item") {
			knife.setRotation();
			knife.getName()
		}
		
		GameObject obj1 = new GameObject();
		obj1.getName(); // "
	}
}