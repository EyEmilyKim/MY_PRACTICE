package y22.m08;

public class Calculator {
	int left, right;

	public Calculator(int left, int right) {
		this.left = left; 
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left + this.right)/2);
	}
	
}
