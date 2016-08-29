package com.witx.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * 使用CXF动态调用webservice，不再生成wsdl类
 * 如果是C#的webservice服务端，则wsdl中有<s:element ref="s:schema" /><s:any />就不能被认出，
 * 需要替换为<s:any minOccurs="2" maxOccurs="2"/>
 * @author Arvin
 *
 */
public class DynamicClient {
	//wsdl的url地址
	private String _url;
	//连接超时
	private long _connectionTimeOut = 3600;
	//接收超时
	private long _reciveTimeOut = 1000;
	
	
	public long get_connectionTimeOut() {
		return _connectionTimeOut;
	}

	public void set_connectionTimeOut(long _connectionTimeOut) {
		this._connectionTimeOut = _connectionTimeOut;
	}

	public long get_reciveTimeOut() {
		return _reciveTimeOut;
	}

	public void set_reciveTimeOut(long _reciveTimeOut) {
		this._reciveTimeOut = _reciveTimeOut;
	}

	public String get_url() {
		return _url;
	}

	public void set_uri(String url) {
		this._url = url;
	}

	public DynamicClient(){
		
	}
	
	public DynamicClient(String url){
		this._url = url;
	}
	
	/**
	 * webservice动态调用的路由
	 * @param methodName 方法名称
	 * @param parm 参数
	 * @return
	 * @throws Exception
	 */
	public Object[] wsRouteServer(String methodName,Object...parm) throws Exception{
		
		JaxWsDynamicClientFactory dynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
		//访问webservice的策略
		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		//连接超时
		httpClientPolicy.setConnectionTimeout(this._connectionTimeOut);
		//接收超时
		httpClientPolicy.setReceiveTimeout(this._reciveTimeOut);
		
		Client client = dynamicClientFactory.createClient(this._url);
		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		conduit.setClient(httpClientPolicy);
		
		return client.invoke(methodName, parm);
		
	}
	
}
