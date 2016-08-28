package com.witx.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class VerificationInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	/**
	 * 定义在 方法调用前 触发此拦截器
	 * @param phase
	 */
	public VerificationInterceptor() {
		super(Phase.PRE_INVOKE);
		
	}

	/**
	 * 解析header
	 */
	public void handleMessage(SoapMessage message) throws Fault {
		
		List<Header> headers = message.getHeaders();
		
		if( headers==null || headers.size()<=0){
			throw new Fault(new IllegalArgumentException("未定义header！"));
		}
		
		Header header = headers.get(0);
		Element ele = (Element) header.getObject();
		
		NodeList ueles = ele.getElementsByTagName("userName");
		NodeList peles = ele.getElementsByTagName("password");
		if(ueles==null || ueles.getLength()<=0||peles==null || peles.getLength()<=0){
			throw new Fault(new IllegalArgumentException("用户名或密码格式错误！"));
		}
		String strUserName = ueles.item(0).getTextContent();
		String strPassword = peles.item(0).getTextContent();
		
		if(!strUserName.equals("lxl")||!strPassword.equals("123456")){
			throw new Fault(new IllegalArgumentException("用户名或密码错误！"));
		}
	}

}
