package y22.m08.exception;

	// 직접 만든 예외: DivideException클래스 생성
	// ↓ 2.checked로 하기 위해 Exception클래스 상속. 
class DivideException2 extends Exception {
	
	public int left; 
	public int right;
	
	DivideException2(){//기본 생성자
		super();
	}
	
	//매개변수가 "3개" 있는 생성자 - 예외 단서 추가!
	DivideException2(String message, int left, int right){
		super(message);
		this.left = left;
		this.right = right;
	}
}

class CalculatorE3{
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}

		//2.Exception - checked
		//2-1. try,catch 처리
	public void divide() {
		try {
			if(this.right==0) {
				throw new DivideException2("0으로 나눌 수 없습니다.", this.left, this.right) ;
			}
			System.out.println(this.left / this.right);
			System.out.println("\nDivide End");
		} catch (DivideException2 e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("입력한 좌항 : "+e.left);
			System.out.println("입력한 우항 : "+e.right);
		}
		
	}
		
		//2-2. throw 처리 -> divide()의 사용자에게 예외 처리 위임
//	public void divide() throws DivideException2 {
//		if(this.right==0) {
//			throw new DivideException2("0으로 나눌 수 없습니다.", this.left, this.right);
//		}
//		System.out.println(this.left / this.right);
//		System.out.println("\nDivide End");
//	}

 }

public class CustumExceptionDemo2 {

		//1, 2-1. 사용자의 예외처리 없음
	public static void main(String[] args) {
		CalculatorE3 c1 = new CalculatorE3();
		c1.setOprands(10, 0);
		c1.divide();
	}
	
		//2-2. throw 처리 -> divide()의 사용자에게 예외 처리 위임
//	public static void main(String[] args) {
//		CalculatorE3 c1 = new CalculatorE3();
//		c1.setOprands(10, 0);
//		try {
//			c1.divide();
//		} catch (DivideException2 e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			System.out.println("입력한 좌항 : "+e.left);
//			System.out.println("입력한 우항 : "+e.right);
//		}
//	}

}

