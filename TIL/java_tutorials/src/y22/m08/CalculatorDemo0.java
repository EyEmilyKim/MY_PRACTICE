package y22.m08;

public class CalculatorDemo0{

	public static void main(String[] args) {

		System.out.println("Class : Calculator0");
		Calculator0 c1 = new Calculator0();
		c1.setOperands(10, 20);
		c1.sum();
		c1.avg();
		
		Calculator0 c2 = new Calculator0();
		c2.setOperands(20, 40);
		c2.sum();
		c2.avg();
		
		System.out.println("Class : Calculator");
		Calculator c3 = new Calculator(10,20);
		c3.sum();
		c3.avg();
				
	}

}
