package y22.m08.exception;

class A {
	private int[] arr = new int[3];
	A() {
		arr[0] = 0;
		arr[1] = 10;
		arr[2] = 20;
	}
	public void z(int first, int second) {
//		System.out.println(arr[first]/arr[second]);
		
		try {
			System.out.println(arr[first]/arr[second]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 발생");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException 발생");
		} catch (Exception e) {
			System.out.println("Exception 발생");
			//포괄적 범주인 "Exception"을 다른 예외보다 먼저 작성하면
			//그보다 아래 줄에 작성된 세부Exception들은 unreachable되어
			//컴파일 에러가 발생하므로 주의.
		} finally {
			System.out.println("finally 실행");
		}
	}
}

public class ExceptionDemo1 {

	public static void main(String[] args) {
		A a = new A();
		a.z(10, 1);
		a.z(1, 0);
		a.z(2, 1);
	}

}
