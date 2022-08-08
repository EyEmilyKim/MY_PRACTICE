package y22.m08.exception;

import java.io.*;

class B {
	void run() throws FileNotFoundException, IOException{
		BufferedReader bReader = null;
		String input = null;
		//↑필요한 변수들이 try 안에 있는 경우, 예외 발생 시 접근 불가해지므로
		//try 밖에서 전역변수로 선언해줄 필요가 있음.
		bReader = new BufferedReader( new FileReader("out.txt"));
		input = bReader.readLine();
		System.out.println(input);
	}
}

class C {
	void run() throws FileNotFoundException, IOException{
		B b = new B();
		b.run();
	}
}

public class ThrowExceptionDemo {
	public static void main(String[] args) {
		C c = new C();
		try {
			c.run();
		} catch (FileNotFoundException e) {
			System.out.println("out.txt 파일을 찾을 수 없습니다.");
			//↑ FileNotFoundException은 IOException의 하위 예외로 생략 가능, 
			//여기서는 예외 처리의 시야를 넓히기 위해 별도로 작성. (처리 순서 주의)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
