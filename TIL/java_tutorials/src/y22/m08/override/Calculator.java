package y22.m08.override;

public class Calculator {
	int left, right;

	//기본 생성자 추가
	public Calculator() {}
	
	public Calculator(int left, int right) {
		this.left = left; 
		this.right = right;
	}
	
	//left, right 초기화 메서드
	public void setOperands(int left, int right) {
		this.left = left; 
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
//	public void avg() {
//		System.out.println((this.left + this.right)/2);
//	}
	public int avg() {
		return ((this.left + this.right)/2);
	}
	
}
