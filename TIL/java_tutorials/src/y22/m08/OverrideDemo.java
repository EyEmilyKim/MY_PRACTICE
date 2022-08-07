package y22.m08;

public class OverrideDemo {

	public static void main(String[] args) {
		SubableCalculator c1 = new SubableCalculator(10,20);
		c1.sub();
		c1.sum();
		System.out.println("평균 : " +c1.avg());

	}

}
