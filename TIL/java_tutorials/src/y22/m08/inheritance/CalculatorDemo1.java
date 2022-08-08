package y22.m08.inheritance;

public class CalculatorDemo1 {
	public static void main(String[] args) {
		
		System.out.println("지정Constructor with 매개변수");
		SubableCalculator c1 = new SubableCalculator(10,20);
		c1.sum();
		c1.avg();
		c1.sub();
		
		
		System.out.println("기본Constructor + setOperand메서드");
		SubableCalculator c2 = new SubableCalculator();
		c2.setOperands(10, 20);
		c2.sum();
		c2.avg();
		c2.sub();
	}
}
