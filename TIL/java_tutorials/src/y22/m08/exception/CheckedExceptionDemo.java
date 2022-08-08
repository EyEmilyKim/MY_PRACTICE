package y22.m08.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionDemo {

	public static void main(String[] args) {
		//out.txt 파일을 읽어서 그것을 화면에 출력하는 내용
		//이 경우 out.txt는 프로젝트의 루트dir에 위치해야한다.
//		BufferedReader bReader = new BufferedReader(new FileReader("out.txt"));
//        String input = bReader.readLine();
//        System.out.println(input); 
        //↑ 이대로는 throws를 처리하지 않았기 때문에 컴파일에 실패한다.
//        Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
//        	Unhandled exception type FileNotFoundException
//        	Unhandled exception type IOException
//
//        	at y22.m08.exception.CheckedExceptionDemo.main(CheckedExceptionDemo.java:13)
		
		BufferedReader bReader = null;
		String input = null;
		//↑필요한 변수들이 try 안에 있는 경우, 예외 발생 시 접근 불가해지므로
		//try 밖에서 전역변수로 선언해줄 필요가 있음.
		try {
			bReader = new BufferedReader( new FileReader("out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			input = bReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(input);

	}

}
