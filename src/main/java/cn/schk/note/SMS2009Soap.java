package cn.schk.note;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-07-13T11:08:17.769+08:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "SMS2009Soap")
@XmlSeeAlso({ObjectFactory.class})
public interface SMS2009Soap {

    @WebMethod(operationName = "ExecuteCommand", action = "http://tempuri.org/ExecuteCommand")
    @RequestWrapper(localName = "ExecuteCommand", targetNamespace = "http://tempuri.org/", className = "cn.schk.note.ExecuteCommand")
    @ResponseWrapper(localName = "ExecuteCommandResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.note.ExecuteCommandResponse")
    @WebResult(name = "ExecuteCommandResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String executeCommand(
        @WebParam(name = "xmlCommand", targetNamespace = "http://tempuri.org/")
        java.lang.String xmlCommand
    );
}