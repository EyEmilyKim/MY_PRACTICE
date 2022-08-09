package y22.m08.constant2;

class Fruit{
	public final static Fruit APPLE = new Fruit();
	public final static Fruit PEACH = new Fruit();
	public final static Fruit BANANA = new Fruit();
}
class Company{
	public final static Company GOOGLE = new Company();
	public final static Company APPLE = new Company();
	public final static Company ORACLE = new Company();
}
//↑ 2.Fruit그룹과 Company그룹 상수의 비교 금지(서로 다른 Type 부여)위해 class를 사용해볼 수 있다.

	interface FRUIT{
		int APPLE=1, PEACH=2, BANANA=3;
	}
	interface COMPANY{
		int GOOGLE=1, APPLE=2, ORACLE=3;
	}
	// ↑ 1.인터페이스를 사용함으로써, 원래는 class 안에서 아래처럼 길게 선언하던 상수들을
	// 간략하게 선언해줄 수 있고, 같은 이름을 가진 상수도 서로 다른 그룹으로 구분해줄 수 있게 됨.
	// * 인터페이스에서 선언된 변수는 무조건 public static final의 속성을 갖는다.
	//	// fruit
	//	public final static int APPLE = 1;
	//	public final static int PEACH = 2;
	//	public final static int BANANA = 3;
	//	// company
	//	public final static int GOOGLE = 1;
	//	//public final static int APPLE = 2;
	//	public final static int ORACLE = 3;

public class ConstantDemo {
	
	public static void main(String[] args) {
		int type = FRUIT.APPLE;
		//그런데 위 type 변수에 COMPANY그룹의 상수를 넣어도 결과는 57kcal이 나온다.
//		int type = COMPANY.GOOGLE;
		switch(type) {
		case FRUIT.APPLE:
			System.out.println(57+"kcal");	break;
		case FRUIT.PEACH:
			System.out.println(34+"kcal");	break;
		case FRUIT.BANANA:
			System.out.println(93+"kcal");	break;
		}
		
		//마찬가지로 아래의 비교 결과는 true이다.(양쪽 모두 값이 정수 1이기 때문)
		if(FRUIT.APPLE == COMPANY.GOOGLE) System.out.println(true);
		//이는 서로 다른 상수그룹의 비교이므로, 논리상 오류이나 컴파일이 잡아주지 못하고 있다. 
		
		//이 문제를 우회하기 위해 아래 방법(class를 통해 상수를 그룹화)이 유효.
		//컴파일 에러 통해 개발자가 사전에 오류 확인 가능.
//		if(Fruit.APPLE == Company.APPLE) {
//			System.out.println("과일 애플과 회사 애플이 같다.");
//		}
		//but 이 코드 역시 불완전: 1.switch 문에서 사용불가 2.선언이 너무 복잡함
		//여기서 enum이 등장 ! ---> ConstantDemo1으로..
		
	}
}
