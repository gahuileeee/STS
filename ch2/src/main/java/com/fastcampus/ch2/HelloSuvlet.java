package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
// 맵핑 + 컨트롤과 같음

public class HelloSuvlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
//		서블릿이 초기화 될 때 자동 호출되는 method
//		1. 서블릿의 초기화 작업을 담당.
		System.out.println("[Helloservlet]init() is called");	}
	
//	요청할 때 마다 service method가 계속 반복 처리 될 것임.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		실제로 처리 되는 곳
//		1. 입력
//		2. 처리
//		3. 출력
		System.out.println("[Helloservlet]service() is called");
	}

	@Override
	public void destroy() {
//		뒷정리: 서블릿이 메모리에서 제거될 때 서블릿 컨테이너 의해서 자동 호출
		System.out.println("[Helloservlet]destroy() is called");
	}

	

}
