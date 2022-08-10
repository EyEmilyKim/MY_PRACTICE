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

//위의 StudentPerson과 EmployeePerson의 중복을 아래처럼 제거해보면??
class Person{
	public Object info;
	Person(Object info){ this.info = info; }
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
		
		Person p1 = new Person(1);
		StudentInfo si = (StudentInfo)p1.info;
		System.out.println(si.grade);

		Person p2 = new Person("부장");
		EmployeeInfo ei = (EmployeeInfo)p2.info;
		System.out.println(ei.rank);
//위의 예는 Person 생성자의 매개변수 Type이 Object기 때문에 "부장"이 들어갈 수 있다. 
//그러나 EmployeeInfo로 넘어갈 것을 생각하면 개발자의 의도에서 벗어난 논리적 오류이다.
//하지만 문법적으로는 문제가 없기 때문에 Compile에러가 발생하지 않고, RuntimeError가 난다.
//:Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class 
//**컴파일 언어의 기본은 모든 에러가 컴파일에서 발생할 수 있도록 유도하는 것!!
//런타임 에러는 항상 심각한 문제를 초래할 수 있다.
//**이와 같은 에러를 [타입에 대해서 안전하지 않다]고 한다.
//그리고 이 문제를 해결하기 위해 등장하는 것이 [제네릭]이다.		


	}
}
