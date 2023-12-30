package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
// ���� + ��Ʈ�Ѱ� ����

public class HelloSuvlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
//		������ �ʱ�ȭ �� �� �ڵ� ȣ��Ǵ� method
//		1. ������ �ʱ�ȭ �۾��� ���.
		System.out.println("[Helloservlet]init() is called");	}
	
//	��û�� �� ���� service method�� ��� �ݺ� ó�� �� ����.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		������ ó�� �Ǵ� ��
//		1. �Է�
//		2. ó��
//		3. ���
		System.out.println("[Helloservlet]service() is called");
	}

	@Override
	public void destroy() {
//		������: ������ �޸𸮿��� ���ŵ� �� ���� �����̳� ���ؼ� �ڵ� ȣ��
		System.out.println("[Helloservlet]destroy() is called");
	}

	

}
