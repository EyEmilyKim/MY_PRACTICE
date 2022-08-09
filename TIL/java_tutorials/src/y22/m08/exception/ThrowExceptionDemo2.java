package y22.m08.exception;

import java.io.IOException;

public class ThrowExceptionDemo2 {
	//ArithmeticException는 에러처리를 하지 않아도 문제 없이 컴파일된다.
	void throwArithmeticException() {
		throw new ArithmeticException();
	}
	
	//IOException은 에러처리를 하지 않는 경우 컴파일 에러가 난다.
	//Problem Description : Unhandled exception type IOException
//	void throwIOException() {
//		throw new IOException();
//	}
	
	//이 문제를 피하기 위해선 아래 두 방법 중 처리를 해줘야 함.
	//1. try,catch 처리
	void throwIOException1() {
		try {
			throw new IOException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//2. throw 처리
	void throwIOException2() throws IOException {
		throw new IOException();
	}
}

//	** IOException 과 ArithmeticEcxeption 의 차이점
//	*IOException은 그냥 Exception클래스 소속, 
//	ArithmeticException은 Exception클래스 하위의 RuntimeException클래스 소속.
//	*예외에는 두가지 종류가 있음↓
//	checked 예외 - RuntimeException을 제외한 Exception의 하위 클래스
//	unchekced 예외 - RuntimeException의 하위 클래스
//	checked 예외는 반드시 예외 처리가 필요하고
//	unchecked 예외는 예외 처리를 해도 되고 안해도 된다.