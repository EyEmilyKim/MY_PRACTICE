package y22.m08.rootobject;

class Student1 implements Cloneable {
	//clone()을 사용하기 위해서는 위와 class선언 Cloneable Interface를 명기해야한다.
	//Cloneable Declaration을 가보면 실제로는 내용이 비어있는 Interface이지만, 
	//이 구분자를 통해 해당 객체가 Cloneable함을 JVM에게 알려주는 역할을 한다.
	String name;
	Student1(String name){
		this.name = name;
	}
	
	//상위클래스 Object의 clone()을 그냥 쓰려고 하면 접근 제어자가 protected라서 에러가 난다.
	//따라서 하위클래스에서 상속하여 public으로 접근을 공개해주고 있다. 
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
		//clone()은 CloneNotSupportedException을 throw 하는 메서드이다.
		//여기서는 사용자에게 예외 처리 위임.
	}
	
}

public class ObjectDemo1 {

	public static void main(String[] args) {
		Student1 s1 = new Student1("egoing");
		try {
		//clone()사용자에서 예외처리를 해주니, clone()사용 가능해졌다.
			Student1 s2 = (Student1)s1.clone();
		//아래의 실행 결과로 피복제본인 s1과 s2의 상태가 같음을 확인할 수 있다.	
			System.out.println(s1.name);
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
