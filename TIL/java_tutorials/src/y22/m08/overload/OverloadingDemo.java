package y22.m08.overload;

public class OverloadingDemo {
	
	void A() {System.out.println("void A()이 실행됨");}
	void A(int arg1) {System.out.println("void A(int arg1)이 실행됨");}
	void A(String arg1) {System.out.println("void A(String arg1)이 실행됨");}
	//int A() {System.out.println("void A()");}

	public static void main(String[] args) {
		OverloadingDemo od = new OverloadingDemo();
		od.A();
		od.A(1);
		od.A("It's rayning outside");
	}

}
