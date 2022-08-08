package y22.m08.constructor;

public class CalculatorDemo{

	public static void main(String[] args) {
		Calculator c1 = new Calculator(10,20);
		c1.sum();
		c1.avg();
		
		Calculator c2 = new Calculator(20,40);
		c2.sum();
		c2.avg();
		
	}

}
