package y22.m08.constant2;

/*class Fruit1{
	public final static Fruit1 APPLE = new Fruit1();
	public final static Fruit1 PEACH = new Fruit1();
	public final static Fruit1 BANANA = new Fruit1();
	private Fruit1(){}
}*/
//*위의 class선언과 아래의 enum선언은 프로그램 문법상 똑같은 의미이다.
//enum : 열거형(enumerated type), 서로 연관된 상수들의 집합. 코드를 단순화 해준다.
//enum도 사실상 클래스이나, 편의를 위해 JAVA 1.5부터 문법적으로 지원. 
//이 코드를 컴파일하면 class선언과 동일하게 Fruit1.class, Company1.class가 생성된다.
//*단 enum은 구현 의도가 오직 "열거"에 있기 때문에, class 생성자의 접근제어자는 private 이다.
//이것은 즉, enum class는 인스턴스화 할 수 없고, 상속을 방지하고 있음을 의미한다.
enum Fruit1{
	APPLE, PEACH, BANANA
}
enum Company1{
	GOOGLE, APPLE, ORACLE
}

public class ConstantDemo1 {
	
	public static void main(String[] args) {
		//아래 코드는 하기의 컴파일 에러가 발생한다 :
		//Incompatible operand types Fruit1 and Company1
		//enum 사용으로 서로 다른 상수 그룹에 대한 비교를 컴파일 시점에서 차단할 수 있다.
//		if(Fruit1.APPLE == Company1.APPLE) {
//			System.out.println("과일 애플과 회사 애플이 같다.");
//		}
		//위처럼 enum은 그룹별 class를 사용했을 때(ConstantDemo 참고)와 똑같은 효과를 갖는다.
		//뿐만 아니라, 아래처럼 Switch문에도 사용이 가능하다!
		Fruit1 type = Fruit1.APPLE;
		switch(type) {
		case APPLE:
			System.out.println(57+"kcal"); 	break;
		case PEACH:
			System.out.println(34+"kcal"); 	break;
		case BANANA:
			System.out.println(93+"kcal"); 	break;
		}
		
	}
}

