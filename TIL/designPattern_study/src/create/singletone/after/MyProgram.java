package create.singletone.after;

public class MyProgram {

	public static void main(String[] args){
		new FirstPage().setAndPrintSettings();
		new SecondPage().printSettings();
	}
}

//* 싱글톤 패턴
//- 코드 내 어디서든, 오직 하나의 인스턴스만 사용할 수 있도록 객체를 생성하는 방법.
//- 즉 객체는 여러 번 생성되지 않고, 최초 하나의(Single) 인스턴스만 생성하고, 
//이후에는 이 인스턴스를 참조하게 된다.
//- 전역적으로 하나의 인스턴스만 사용, 참조해야하는 경우에 사용한다.