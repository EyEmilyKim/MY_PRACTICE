package y22.m08.rootobject;

import java.util.Objects;

class Student {
	String name;
	Student(String name){
		this.name = name;
	}
	
	public boolean equals(Object obj) {
	       Student _obj = (Student)obj;
	       return name == _obj.name;
	   }
	//↑임의로 equals()를 오버라이딩.
	//**원래는 이 equals()를 제대로 구현하려면 hashCode()도 같이 작성을 해줘야하지만
	//지금 레슨에서는 pass. 
	//(↓참고)equals 우클릭> Source> [Generate hashcode()and equlas()]
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		return Objects.equals(name, other.name);
//	}
	
}

public class ObjectDemo {

	public static void main(String[] args) {
		Student s1 = new Student("egoing");
		Student s2 = new Student("egoing");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		//오버라이딩 전 equals 결과: false (s1과 s2가 서로 다른 객체이기 때문)
		//오버라이딩 후 equals 결과: true (인자로 전달된 객체의 name값을 비교하도록 재정의)
	}
}
