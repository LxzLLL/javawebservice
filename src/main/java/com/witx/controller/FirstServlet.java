package com.witx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.webxml.MobileCodeWSSoap;

/**
 * Servlet implementation class FisrstServlet
 */
@WebServlet(name="FirstServlet",urlPatterns="/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("执行FirstServlet");
		response.setCharacterEncoding("UTF-8");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("------>"+context);
		MobileCodeWSSoap weatherWSSoap = (MobileCodeWSSoap) context.getBean("WSService");
		System.out.println("--------->"+weatherWSSoap);
		
		//WeatherWSSoap weatherWSSoap = ws.getWeatherWSSoap();
		String strs = weatherWSSoap.getMobileCodeInfo("13726299610", null);
		
		
		
		
		System.out.println("------>"+strs);
		response.getWriter().append(strs);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
