package y22.m08.constant2;

enum Fruit2{
	APPLE("red","사과"), PEACH("pink","복숭아"), BANANA("yellow","바나나");
	public String color;
	private String name;
	Fruit2(String color, String name) {
		System.out.println("call constructor "+this);
		this.color = color;
		this.name = name;
	}
	//↑ enum도 class이기 때문에 필드와 생성자를 가질 수 있다. 
	//상수를 선언함과 동시에 생성자를 호출, 4행처럼 매개변수를 전달하고 있다.
	public String getName() {
		return this.name;
	}
	//↑ enum은 메서드도 당연히 가질 수 있다. class니까. 
	//(메서드에서 사용하는 필드의 접근제어자는 private으로 지정해주는 것이 좋다. [6행])
	
}

public class ConstantDemo2 {
	
	public static void main(String[] args) {

		Fruit2 type = Fruit2.APPLE;
		switch(type) {
		case APPLE:
			System.out.println(57+"kcal, color "+Fruit2.APPLE.color); 	break;
		case PEACH:
			System.out.println(34+"kcal, color "+Fruit2.PEACH.color); 	break;
		case BANANA:
			System.out.println(93+"kcal, color "+Fruit2.BANANA.color); 	break;
		}
		
		Fruit2 type2 = Fruit2.PEACH;
		switch(type2) {
		case APPLE:
			System.out.println(57+"kcal, name "+Fruit2.APPLE.getName()); 	break;
		case PEACH:
			System.out.println(34+"kcal, name "+Fruit2.PEACH.getName()); 	break;
		case BANANA:
			System.out.println(93+"kcal, name "+Fruit2.BANANA.getName()); 	break;
		}
		
		//↓ enum이 일반 class와 다른 점
		//enum은 마치 배열처럼 열거된 객체 전체를 열거할 수도 있다!
		for(Fruit2 f : Fruit2.values()) {
			System.out.println(f+f.getName()+f.color);
		}
	
		//**enum 의 특성 정리
		// - 연관된 값들을 저장하고, 그 값들이 변경되지 않도록 보장한다.
		// - 그 자체가 class이기 때문에 enum 내부에 생성자, 필드, 메소드를 가질 수 있어
		//   단순히 상수가 아니라 더 많은 역할을 할 수 있다.
		// - 일반 class와 달리 enum 에 열거된 객체를 열거할 수 있다. values()메서드.   
	}
}

