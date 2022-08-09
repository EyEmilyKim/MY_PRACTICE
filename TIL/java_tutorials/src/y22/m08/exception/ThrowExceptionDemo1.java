package y22.m08.exception;

class CalculatorE{
	int left, right;
	public void setOprands(int left, int right) {
		//아래처럼 "의도하지 않은 매개변수 예외"를 지정할 수 있다.(우항에 0 금지) 
		//프로그램 논리상으로는 옳지 않은 선택..(sum, sub, mul 연산 등에 위배됨)
//		if(right==0) {
//			throw new IllegalArgumentException("두번째 인자의 값은 0이 될 수 없습니다.");
//		}		
		
		this.left = left;
		this.right = right;
	}
	public void divide() {
		//divide()의 산술 연산 예외 처리 (0으로 나누는걸 금지)
		if(this.right==0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		
		try {
			System.out.print("계산결과는 ");
			System.out.print(this.left/this.right);
			System.out.print(" 입니다.");
		} catch (Exception e) {
			System.out.println("\ne.getMessage()는\n"+e.getMessage());
			System.out.println("\ne.toString()는\n"+e.toString());
			System.out.println("\ne.printStackTrace()는");
			e.printStackTrace();
		}
		System.out.println("\nDivide End");
	}

}

public class ThrowExceptionDemo1 {

	public static void main(String[] args) {
		CalculatorE c1 = new CalculatorE();
		c1.setOprands(10, 0);
		c1.divide();
	}

}
