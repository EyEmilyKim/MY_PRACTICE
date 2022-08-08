package y22.m08.polymorphism;

public class CalculatorDemo {
    public static void execute(Calculator cal){
        System.out.println("---실행결과---");
        cal.run();
    }
    public static void main(String[] args) { 
        Calculator c1 = new CalculatorDecoPlus();
        c1.setOprands(10, 20);
         
        Calculator c2 = new CalculatorDecoMinus();
        c2.setOprands(10, 20);
        
        //서로 다른 객체인 c1과 c2의 타입을 Calculator로 해줌으로써 (매개변수 통일)
        //서로 같은 메서드execute()로 서로 다른 결과 수행 -> 다형성!
        execute(c1);
        execute(c2);
        
        System.out.println("==하위클래스에서 구체화한 sum()메서드==");
        c1.sum();
        c2.sum();
        
        System.out.println("==슈퍼클래스의 run()메서드==");
        c1.run();
        c2.run();
        
        System.out.println();
        
        //test
        //execute()의 매개변수 타입은 슈퍼클래스 데이터형인데,
        //인자의 데이터형을 하위클래스 데이터형으로 줘도 실행될까?
        //결과 : 된다 ! => 다형성!!
        CalculatorDecoPlus c3 = new CalculatorDecoPlus();
        c3.setOprands(10, 20);
        c3.sum();
        execute(c3);

        System.out.println();

        CalculatorDecoMinus	c4 = new CalculatorDecoMinus();
        c4.setOprands(10, 20);
        c4.sum();
        execute(c4);
    }
}
