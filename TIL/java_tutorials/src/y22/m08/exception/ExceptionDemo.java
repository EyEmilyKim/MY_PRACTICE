package y22.m08.exception;

class Calculator{
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public void divide() {
//		System.out.println("계산결과는 ");
//		System.out.println(this.left/this.right);
//		System.out.println(" 입니다.");

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
public class ExceptionDemo {
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setOprands(10, 0);
		c1.divide();
		
		Calculator c2 = new Calculator();
		c2.setOprands(10, 5);
		c2.divide();
		
	}

}
