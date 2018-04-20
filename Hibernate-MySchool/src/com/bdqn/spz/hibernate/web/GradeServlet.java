package com.bdqn.spz.hibernate.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.spz.hibernate.entity.Grade;
import com.bdqn.spz.hibernate.service.IGradeService;
import com.bdqn.spz.hibernate.service.impl.GradeServiceImpl;

@SuppressWarnings("serial")
public class GradeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		IGradeService gradeService=new GradeServiceImpl();
		Grade grade=gradeService.findGradeById(1);
		System.out.println(grade.getGradeName());
		request.setAttribute("grade",grade);
		request.getRequestDispatcher("index.jsp").forward(request, response);;
	}

}
