package y22.m08;

public class SubableCalculator extends Calculator {
	
	//기본 생성자 추가
	public SubableCalculator() {}
	
	public SubableCalculator(int left, int right) {
		super(left, right);
	}

	public void sub() {
		System.out.println(this.left - this.right);
	}
	
	public void sum() {
		System.out.println("합 : " + (this.left + this.right));
	}
	
	public int avg() {
		return super.avg();
	}
}

