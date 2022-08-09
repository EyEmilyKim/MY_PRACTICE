package y22.m08.rootobject;

class Calculator{
//↑	이 문장은 사실 == class Calculator extends Object{ } == 와 같다.
//즉 우리가 사용하는 모든 class들은 Object class를 자동적으로 상속하고 있다.	
    int left, right;
      
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void sum(){
        System.out.println(this.left+this.right);
    }
      
    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
    
    //Object 클래스의 기본 toString()메서드 :
    //return getClass().getName() + "@" + Integer.toHexString(hashCode());
    //↓ 오버라이딩: 우리가 원하는 내용으로 toString()메서드를 재정의  
    public String toString() {
    	return super.toString()+"\n left:"+this.left+", right:"+this.right;
    }
}
  
public class CalculatorDemo {
      
    public static void main(String[] args) {
          
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        
//      System.out.println(c1);
        //사실 ↑ 와 ↓는 같은 문장이다.  
        //toString 메소드는 자바에서 특별히 취급하는 메소드로, 
        //어떤 객체를 System.out.print로 호출하면 
        //자동으로 toString이 호출되도록 약속되어 있다.
      System.out.println(c1.toString());
    }
  
}