package y22.m08.Reference;

class A {
	public int id;
	A(int id){
		this.id = id;
	}
}

public class ReferenceDemo1 {

	public static void runValue() {
		//primitive type의 대입원을 변경하면
		//해당 변수의 값만 바뀐다.
		int a = 1;
		int b = a;
		b = 2;
		System.out.println("runValue, "+a);
	}
	
	public static void runReference() {
		//reference type의 대입원을 변경하면
		//그것을 참조하고 있는 모든 변수의 값이 바뀐다.
		A a = new A(1);
		A b = a;
		b.id = 2;
		System.out.println("runReference, "+a.id);
	}
	public static void runReference_() {
		//reference type의 대입원을 변경하면
		//그것을 참조하고 있는 모든 변수의 값이 바뀐다.
		A a = new A(1);
		A b = a;
		//↓여기서 a의 대입원과 b의 대입원이 달라짐.
		b = new A(2);
		System.out.println("runReference, "+a.id);
	}
	
	public static void main(String[] args) {
		runValue();
		runReference();
		runReference_();
	}
}
