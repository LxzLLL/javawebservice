package cn.com.webxml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-08-29T20:33:43.201+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://WebXml.com.cn/", name = "MobileCodeWSSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface MobileCodeWSSoap {

    /**
     * <br /><h3>获得国内手机号码归属地省份、地区和手机卡类型信息</h3><p>输入参数：mobileCode = 字符串（手机号码，最少前7位数字），userID = 字符串（商业用户ID） 免费用户为空字符串；返回数据：字符串（手机号码：省份 城市 手机卡类型）。</p><br />
     */
    @WebMethod(action = "http://WebXml.com.cn/getMobileCodeInfo")
    @RequestWrapper(localName = "getMobileCodeInfo", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetMobileCodeInfo")
    @ResponseWrapper(localName = "getMobileCodeInfoResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetMobileCodeInfoResponse")
    @WebResult(name = "getMobileCodeInfoResult", targetNamespace = "http://WebXml.com.cn/")
    public java.lang.String getMobileCodeInfo(
        @WebParam(name = "mobileCode", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String mobileCode,
        @WebParam(name = "userID", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String userID
    );

    /**
     * <br /><h3>获得国内手机号码归属地数据库信息</h3><p>输入参数：无；返回数据：一维字符串数组（省份 城市 记录数量）。</p><br />
     */
    @WebMethod(action = "http://WebXml.com.cn/getDatabaseInfo")
    @RequestWrapper(localName = "getDatabaseInfo", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetDatabaseInfo")
    @ResponseWrapper(localName = "getDatabaseInfoResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetDatabaseInfoResponse")
    @WebResult(name = "getDatabaseInfoResult", targetNamespace = "http://WebXml.com.cn/")
    public cn.com.webxml.ArrayOfString getDatabaseInfo();
}