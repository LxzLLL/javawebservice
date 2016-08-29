package com.witx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.witx.webservice.DynamicClient;

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
		response.setContentType("text/html;charset=UTF-8");

		//spring+cxf方式调用webservice
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("------>"+context);
		MobileCodeWSSoap codeWSSoap = (MobileCodeWSSoap) context.getBean("WSService");
		System.out.println("--------->"+weatherWSSoap);
		
		String strs = codeWSSoap.getMobileCodeInfo("13726299610", null);
		System.out.println("------>"+strs);
		response.getWriter().append(strs);*/
		
		//动态调用webservice
		/*JaxWsDynamicClientFactory dynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
		
		Client client = dynamicClientFactory.createClient("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
		try {
			Object[] objects = client.invoke("getMobileCodeInfo", new Object[]{"13726299610",null});
			response.getWriter().append(objects[0].toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//组装为类
		String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl";
		DynamicClient dynamicClient = new DynamicClient(url);
		try {
			Object[] objects = dynamicClient.wsRouteServer("getMobileCodeInfo", new Object[]{"13726538690",null});
			response.getWriter().append(objects[0].toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
