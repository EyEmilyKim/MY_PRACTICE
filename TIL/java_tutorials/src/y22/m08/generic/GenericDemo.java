package y22.m08.generic;

class StudentInfo {
	public int grade;
	StudentInfo(int grade){ this.grade = grade; }
}
//class StudentPerson {
//	public StudentInfo info;
//	StudentPerson(StudentInfo info){ this.info = info; }
//}

class EmployeeInfo {
	public int rank;
	EmployeeInfo(int rank){ this.rank = rank; }
}
//class EmployeePerson {
//	public EmployeeInfo info;
//	EmployeePerson(EmployeeInfo info){ this.info = info; }
//}

/* 위의 StudentPerson과 EmployeePerson의 중복을 아래처럼 제거해보면?? */
class Person{
	public Object info;
	Person(Object info){ this.info = info; }
}

/* 제네릭을 이용해서 위의 중복 해결하면?? */
class Person1<T>{
	public T info;
	Person1(T info){ this.info = info; }
}

class Person2<T,S>{
	public T info;
	public S id;
	Person2(T info, S id){
		this.info = info; 
		this.id = id; 
	}
	public <U> void printInfo(U info) {
		System.out.println(info);
	}//제네릭은 메서드에도 적용할 수 있다.
}


public class GenericDemo {
	public static void main(String[] args) {
//		StudentInfo si = new StudentInfo(2);
//		StudentPerson sp = new StudentPerson(si);
//		System.out.println(sp.info.grade); //결과: 2
//		
//		EmployeeInfo ei = new EmployeeInfo(1);
//		EmployeePerson ep = new EmployeePerson(ei);
//		System.out.println(ep.info.rank);//결과: 1
/* StudentPerson 과 EmployeePerson 클래스 이용한 개체 생성 */
		
//		Person p1 = new Person(1);
//		StudentInfo si = (StudentInfo)p1.info;
//		System.out.println(si.grade);
//
//		Person p2 = new Person("부장");
//		EmployeeInfo ei = (EmployeeInfo)p2.info;
//		System.out.println(ei.rank);
/* Person 클래스를 이용한 개체 생성 : 옳지 않음...
 * 위의 예는 Person 생성자의 매개변수 Type이 Object기 때문에 "부장"이 들어갈 수 있다. 
그러나 EmployeeInfo로 넘어갈 것을 생각하면 개발자의 의도에서 벗어난 논리적 오류이다.
하지만 문법적으로는 문제가 없기 때문에 Compile에러가 발생하지 않고, RuntimeError가 난다.
:Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class 
**컴파일 언어의 기본은 모든 에러가 컴파일에서 발생할 수 있도록 유도하는 것!!
런타임 에러는 항상 심각한 문제를 초래할 수 있다.
**이와 같은 에러를 [타입에 대해서 안전하지 않다]고 한다.
그리고 이 문제를 해결하기 위해 등장하는 것이 [제네릭]이다.*/		

		Person1<EmployeeInfo> p3 = new Person1<EmployeeInfo>(new EmployeeInfo(1));
		EmployeeInfo ei1 = p3.info;
		System.out.println("Person1 클래스의 p3 : "+ei1.rank);
		//↑결과: 1
//		Person1<String> p4 = new Person1<String>("부장");
//		String ei2 = p4.info;
//		System.out.println(ei2.rank);
		//↑컴파일 실패:
		//Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		//rank cannot be resolved or is not a field
		//at y22.m08.generic.GenericDemo.main(GenericDemo.java:67)
/* 제네릭을 이용한 코드에서는 
 * 중복의 제거와 타입 안전성을 동시에 해결, 의도에 맞게 개체 생성이 되고 있다.
 */

//		Person2<EmployeeInfo,int> p5 = new Person2<EmployeeInfo,int>(new EmplyeeInfo(1),1);
		//이 코드는 예외를 발생시킨다.
		//제네릭은 참조형에 대해서만 사용할 수 있다!
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(2);
		Person2<EmployeeInfo, Integer> p5 = new Person2<EmployeeInfo, Integer>(e,i);
		System.out.println("Person2 클래스의 p5 : "+p5.id.intValue());
		//intValue()는 Integer 안에 들어있는 정수 값을 기본형으로 돌려주는 메서드
		
		EmployeeInfo e1 = new EmployeeInfo(1);
		Integer i1 = new Integer(3);
		Person2 p6 = new Person2(e1,i1);		
		//위 경우, 제네릭의 매개변수로 들어갈 Type은 매개변수로 지정된 
		//i1, p6의 선언시 명시된 타입을 통해 컴파일러가 알 수 있으므로 생략 가능. 
		p6.<EmployeeInfo>printInfo(e1);
		p6.printInfo(e1);
		//제네릭 적용된 메서드 호출. 
		//여기서도 Type은 생략 가능, [103]와[104]가 같다.
		
				
	}
}
