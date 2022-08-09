package y22.m08.exception;

	// 직접 만든 예외: DivideException클래스 생성
	// ↓ 1.unchecked로 하기 위해 RuntimeException클래스 상속. 
//class DivideException extends RuntimeException {

	// ↓ 2.checked로 하기 위해 Exception클래스 상속. 
class DivideException extends Exception {
	
	DivideException(){//기본 생성자
		super();
	}
	
	DivideException(String message){//String 매개변수가 있는 생성자
		super(message);
	}
}

class CalculatorE2{
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
		//divide()의 예외를 직접 만든 DivideException으로 처리.
		//1.RuntimeException - unchecked
//	public void divide() {
//		if(this.right==0) {
//			throw new DivideException("0으로 나눌 수 없습니다.");
//		}
//		System.out.println(this.left / this.right);
//		System.out.println("\nDivide End");
//	}
	
		//2.Exception - checked
		//2-1. try,catch 처리
	public void divide() {
		try {
			if(this.right==0) {
				throw new DivideException("0으로 나눌 수 없습니다.");
			}
			System.out.println(this.left / this.right);
			System.out.println("\nDivide End");
		} catch (DivideException e) {
			e.printStackTrace();
		}
		
	}	
		
		//2-2. throw 처리 -> divide()의 사용자에게 예외 처리 위임
//	public void divide() throws DivideException {
//		if(this.right==0) {
//			throw new DivideException("0으로 나눌 수 없습니다.");
//		}
//		System.out.println(this.left / this.right);
//		System.out.println("\nDivide End");
//			
//	}

}

public class CustumExceptionDemo {

		//1, 2-1. 사용자의 예외처리 없음
	public static void main(String[] args) {
		CalculatorE2 c1 = new CalculatorE2();
		c1.setOprands(10, 0);
		c1.divide();
	}
	
		//2-2. throw 처리 -> divide()의 사용자에게 예외 처리 위임
//	public static void main(String[] args) {
//		CalculatorE2 c1 = new CalculatorE2();
//		c1.setOprands(10, 0);
//		try {
//			c1.divide();
//		} catch (DivideException e) {
//			e.printStackTrace();
//		}
//	}

}
