package cn.schk.oa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-28T11:00:42.756+08:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "OaWfWebServiceSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface OaWfWebServiceSoap {

    @WebMethod(operationName = "BatchDeleteWFInstances", action = "http://tempuri.org/BatchDeleteWFInstances")
    @RequestWrapper(localName = "BatchDeleteWFInstances", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchDeleteWFInstances")
    @ResponseWrapper(localName = "BatchDeleteWFInstancesResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchDeleteWFInstancesResponse")
    @WebResult(name = "BatchDeleteWFInstancesResult", targetNamespace = "http://tempuri.org/")
    public cn.schk.oa.ArrayOfString batchDeleteWFInstances(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "entitys", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.ArrayOfWFInterfaceEntity2 entitys
    );

    @WebMethod(operationName = "UpdateWFInstanceStatusByInterfaceID", action = "http://tempuri.org/UpdateWFInstanceStatusByInterfaceID")
    @RequestWrapper(localName = "UpdateWFInstanceStatusByInterfaceID", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByInterfaceID")
    @ResponseWrapper(localName = "UpdateWFInstanceStatusByInterfaceIDResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByInterfaceIDResponse")
    @WebResult(name = "UpdateWFInstanceStatusByInterfaceIDResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatusByInterfaceID(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "interfaceID", targetNamespace = "http://tempuri.org/")
        java.lang.String interfaceID,
        @WebParam(name = "user_ID_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userIDConsigned,
        @WebParam(name = "user_Name_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userNameConsigned,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime,
        @WebParam(name = "finishTime", targetNamespace = "http://tempuri.org/")
        java.lang.String finishTime
    );

    @WebMethod(operationName = "GetUserOpinions", action = "http://tempuri.org/GetUserOpinions")
    @RequestWrapper(localName = "GetUserOpinions", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.GetUserOpinions")
    @ResponseWrapper(localName = "GetUserOpinionsResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.GetUserOpinionsResponse")
    @WebResult(name = "GetUserOpinionsResult", targetNamespace = "http://tempuri.org/")
    public cn.schk.oa.ArrayOfString getUserOpinions(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "employeeID", targetNamespace = "http://tempuri.org/")
        java.lang.String employeeID
    );

    @WebMethod(operationName = "UpdateWFInstanceStatus3", action = "http://tempuri.org/UpdateWFInstanceStatus3")
    @RequestWrapper(localName = "UpdateWFInstanceStatus3", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatus3")
    @ResponseWrapper(localName = "UpdateWFInstanceStatus3Response", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatus3Response")
    @WebResult(name = "UpdateWFInstanceStatus3Result", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatus3(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "instanceID", targetNamespace = "http://tempuri.org/")
        java.lang.String instanceID,
        @WebParam(name = "stepID", targetNamespace = "http://tempuri.org/")
        java.lang.String stepID,
        @WebParam(name = "user_ID_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userIDConsigned,
        @WebParam(name = "user_Name_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userNameConsigned,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime,
        @WebParam(name = "finishTime", targetNamespace = "http://tempuri.org/")
        java.lang.String finishTime,
        @WebParam(name = "newFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newFormUrl,
        @WebParam(name = "newMobileFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newMobileFormUrl,
        @WebParam(name = "newInternetFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newInternetFormUrl
    );

    @WebMethod(operationName = "UpdateWFInstanceStatus2", action = "http://tempuri.org/UpdateWFInstanceStatus2")
    @RequestWrapper(localName = "UpdateWFInstanceStatus2", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatus2")
    @ResponseWrapper(localName = "UpdateWFInstanceStatus2Response", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatus2Response")
    @WebResult(name = "UpdateWFInstanceStatus2Result", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatus2(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "instanceID", targetNamespace = "http://tempuri.org/")
        java.lang.String instanceID,
        @WebParam(name = "stepID", targetNamespace = "http://tempuri.org/")
        java.lang.String stepID,
        @WebParam(name = "user_ID_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userIDConsigned,
        @WebParam(name = "user_Name_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userNameConsigned,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime,
        @WebParam(name = "finishTime", targetNamespace = "http://tempuri.org/")
        java.lang.String finishTime,
        @WebParam(name = "newFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newFormUrl
    );

    @WebMethod(operationName = "BatchUpdateWFInstances", action = "http://tempuri.org/BatchUpdateWFInstances")
    @RequestWrapper(localName = "BatchUpdateWFInstances", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchUpdateWFInstances")
    @ResponseWrapper(localName = "BatchUpdateWFInstancesResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchUpdateWFInstancesResponse")
    @WebResult(name = "BatchUpdateWFInstancesResult", targetNamespace = "http://tempuri.org/")
    public cn.schk.oa.ArrayOfString batchUpdateWFInstances(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "entitys", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.ArrayOfWFInterfaceEntity2 entitys
    );

    @WebMethod(operationName = "GetInterfaceEntity", action = "http://tempuri.org/GetInterfaceEntity")
    @RequestWrapper(localName = "GetInterfaceEntity", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.GetInterfaceEntity")
    @ResponseWrapper(localName = "GetInterfaceEntityResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.GetInterfaceEntityResponse")
    @WebResult(name = "GetInterfaceEntityResult", targetNamespace = "http://tempuri.org/")
    public cn.schk.oa.WFInterfaceEntity getInterfaceEntity(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "instanceID", targetNamespace = "http://tempuri.org/")
        java.lang.String instanceID,
        @WebParam(name = "stepID", targetNamespace = "http://tempuri.org/")
        java.lang.String stepID
    );

    @WebMethod(operationName = "BatchInsertNewWFInstances", action = "http://tempuri.org/BatchInsertNewWFInstances")
    @RequestWrapper(localName = "BatchInsertNewWFInstances", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchInsertNewWFInstances")
    @ResponseWrapper(localName = "BatchInsertNewWFInstancesResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchInsertNewWFInstancesResponse")
    @WebResult(name = "BatchInsertNewWFInstancesResult", targetNamespace = "http://tempuri.org/")
    public cn.schk.oa.ArrayOfWFInterfaceEntity2 batchInsertNewWFInstances(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "entitys", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.ArrayOfWFInterfaceEntity2 entitys
    );

    @WebMethod(operationName = "BatchUpdateWFInstancesForTokenLogIn", action = "http://tempuri.org/BatchUpdateWFInstancesForTokenLogIn")
    @RequestWrapper(localName = "BatchUpdateWFInstancesForTokenLogIn", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchUpdateWFInstancesForTokenLogIn")
    @ResponseWrapper(localName = "BatchUpdateWFInstancesForTokenLogInResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.BatchUpdateWFInstancesForTokenLogInResponse")
    @WebResult(name = "BatchUpdateWFInstancesForTokenLogInResult", targetNamespace = "http://tempuri.org/")
    public cn.schk.oa.ArrayOfString batchUpdateWFInstancesForTokenLogIn(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "entitys", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.ArrayOfWFInterfaceEntity2 entitys
    );

    @WebMethod(operationName = "GetInterfaceEntity2", action = "http://tempuri.org/GetInterfaceEntity2")
    @RequestWrapper(localName = "GetInterfaceEntity2", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.GetInterfaceEntity2")
    @ResponseWrapper(localName = "GetInterfaceEntity2Response", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.GetInterfaceEntity2Response")
    @WebResult(name = "GetInterfaceEntity2Result", targetNamespace = "http://tempuri.org/")
    public cn.schk.oa.WFInterfaceEntity getInterfaceEntity2(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "interfaceID", targetNamespace = "http://tempuri.org/")
        java.lang.String interfaceID
    );

    @WebMethod(operationName = "SetWFInstanceReadByInterfaceID", action = "http://tempuri.org/SetWFInstanceReadByInterfaceID")
    @RequestWrapper(localName = "SetWFInstanceReadByInterfaceID", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.SetWFInstanceReadByInterfaceID")
    @ResponseWrapper(localName = "SetWFInstanceReadByInterfaceIDResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.SetWFInstanceReadByInterfaceIDResponse")
    @WebResult(name = "SetWFInstanceReadByInterfaceIDResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String setWFInstanceReadByInterfaceID(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "interfaceID", targetNamespace = "http://tempuri.org/")
        java.lang.String interfaceID,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime
    );

    @WebMethod(operationName = "UpdateWFInstanceStatus", action = "http://tempuri.org/UpdateWFInstanceStatus")
    @RequestWrapper(localName = "UpdateWFInstanceStatus", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatus")
    @ResponseWrapper(localName = "UpdateWFInstanceStatusResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusResponse")
    @WebResult(name = "UpdateWFInstanceStatusResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatus(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "instanceID", targetNamespace = "http://tempuri.org/")
        java.lang.String instanceID,
        @WebParam(name = "stepID", targetNamespace = "http://tempuri.org/")
        java.lang.String stepID,
        @WebParam(name = "user_ID_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userIDConsigned,
        @WebParam(name = "user_Name_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userNameConsigned,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime,
        @WebParam(name = "finishTime", targetNamespace = "http://tempuri.org/")
        java.lang.String finishTime
    );

    @WebMethod(operationName = "UpdateWFInstanceStatusByInterfaceID3", action = "http://tempuri.org/UpdateWFInstanceStatusByInterfaceID3")
    @RequestWrapper(localName = "UpdateWFInstanceStatusByInterfaceID3", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByInterfaceID3")
    @ResponseWrapper(localName = "UpdateWFInstanceStatusByInterfaceID3Response", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByInterfaceID3Response")
    @WebResult(name = "UpdateWFInstanceStatusByInterfaceID3Result", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatusByInterfaceID3(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "interfaceID", targetNamespace = "http://tempuri.org/")
        java.lang.String interfaceID,
        @WebParam(name = "user_ID_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userIDConsigned,
        @WebParam(name = "user_Name_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userNameConsigned,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime,
        @WebParam(name = "finishTime", targetNamespace = "http://tempuri.org/")
        java.lang.String finishTime,
        @WebParam(name = "newFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newFormUrl,
        @WebParam(name = "newMobileFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newMobileFormUrl,
        @WebParam(name = "newInternetFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newInternetFormUrl
    );

    @WebMethod(operationName = "UpdateWFInstanceStatusByInterfaceID2", action = "http://tempuri.org/UpdateWFInstanceStatusByInterfaceID2")
    @RequestWrapper(localName = "UpdateWFInstanceStatusByInterfaceID2", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByInterfaceID2")
    @ResponseWrapper(localName = "UpdateWFInstanceStatusByInterfaceID2Response", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByInterfaceID2Response")
    @WebResult(name = "UpdateWFInstanceStatusByInterfaceID2Result", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatusByInterfaceID2(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "interfaceID", targetNamespace = "http://tempuri.org/")
        java.lang.String interfaceID,
        @WebParam(name = "user_ID_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userIDConsigned,
        @WebParam(name = "user_Name_Consigned", targetNamespace = "http://tempuri.org/")
        java.lang.String userNameConsigned,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime,
        @WebParam(name = "finishTime", targetNamespace = "http://tempuri.org/")
        java.lang.String finishTime,
        @WebParam(name = "newFormUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String newFormUrl
    );

    @WebMethod(operationName = "InsertNewWFInstanceByEntity2", action = "http://tempuri.org/InsertNewWFInstanceByEntity2")
    @RequestWrapper(localName = "InsertNewWFInstanceByEntity2", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.InsertNewWFInstanceByEntity2")
    @ResponseWrapper(localName = "InsertNewWFInstanceByEntity2Response", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.InsertNewWFInstanceByEntity2Response")
    @WebResult(name = "InsertNewWFInstanceByEntity2Result", targetNamespace = "http://tempuri.org/")
    public java.lang.String insertNewWFInstanceByEntity2(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "entity", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.WFInterfaceEntity2 entity
    );

    @WebMethod(operationName = "UpdateWFInstanceStatusByEntity", action = "http://tempuri.org/UpdateWFInstanceStatusByEntity")
    @RequestWrapper(localName = "UpdateWFInstanceStatusByEntity", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByEntity")
    @ResponseWrapper(localName = "UpdateWFInstanceStatusByEntityResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusByEntityResponse")
    @WebResult(name = "UpdateWFInstanceStatusByEntityResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatusByEntity(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "newEntity", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.WFInterfaceEntity2 newEntity
    );

    @WebMethod(operationName = "DeleteEntity", action = "http://tempuri.org/DeleteEntity")
    @RequestWrapper(localName = "DeleteEntity", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.DeleteEntity")
    @ResponseWrapper(localName = "DeleteEntityResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.DeleteEntityResponse")
    @WebResult(name = "DeleteEntityResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String deleteEntity(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "instanceID", targetNamespace = "http://tempuri.org/")
        java.lang.String instanceID,
        @WebParam(name = "stepID", targetNamespace = "http://tempuri.org/")
        java.lang.String stepID
    );

    @WebMethod(operationName = "InsertNewWFInstanceByEntity", action = "http://tempuri.org/InsertNewWFInstanceByEntity")
    @RequestWrapper(localName = "InsertNewWFInstanceByEntity", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.InsertNewWFInstanceByEntity")
    @ResponseWrapper(localName = "InsertNewWFInstanceByEntityResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.InsertNewWFInstanceByEntityResponse")
    @WebResult(name = "InsertNewWFInstanceByEntityResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String insertNewWFInstanceByEntity(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "entity", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.WFInterfaceEntity entity
    );

    @WebMethod(operationName = "SetWFInstanceRead", action = "http://tempuri.org/SetWFInstanceRead")
    @RequestWrapper(localName = "SetWFInstanceRead", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.SetWFInstanceRead")
    @ResponseWrapper(localName = "SetWFInstanceReadResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.SetWFInstanceReadResponse")
    @WebResult(name = "SetWFInstanceReadResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String setWFInstanceRead(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "instanceID", targetNamespace = "http://tempuri.org/")
        java.lang.String instanceID,
        @WebParam(name = "stepID", targetNamespace = "http://tempuri.org/")
        java.lang.String stepID,
        @WebParam(name = "readTime", targetNamespace = "http://tempuri.org/")
        java.lang.String readTime
    );

    @WebMethod(operationName = "DeleteEntity2", action = "http://tempuri.org/DeleteEntity2")
    @RequestWrapper(localName = "DeleteEntity2", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.DeleteEntity2")
    @ResponseWrapper(localName = "DeleteEntity2Response", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.DeleteEntity2Response")
    @WebResult(name = "DeleteEntity2Result", targetNamespace = "http://tempuri.org/")
    public java.lang.String deleteEntity2(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "interfaceID", targetNamespace = "http://tempuri.org/")
        java.lang.String interfaceID
    );

    @WebMethod(operationName = "UpdateWFInstanceStatusForTokenLogIn", action = "http://tempuri.org/UpdateWFInstanceStatusForTokenLogIn")
    @RequestWrapper(localName = "UpdateWFInstanceStatusForTokenLogIn", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusForTokenLogIn")
    @ResponseWrapper(localName = "UpdateWFInstanceStatusForTokenLogInResponse", targetNamespace = "http://tempuri.org/", className = "cn.schk.oa.UpdateWFInstanceStatusForTokenLogInResponse")
    @WebResult(name = "UpdateWFInstanceStatusForTokenLogInResult", targetNamespace = "http://tempuri.org/")
    public java.lang.String updateWFInstanceStatusForTokenLogIn(
        @WebParam(name = "projectCode", targetNamespace = "http://tempuri.org/")
        java.lang.String projectCode,
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "newEntity", targetNamespace = "http://tempuri.org/")
        cn.schk.oa.WFInterfaceEntity2 newEntity
    );
}
