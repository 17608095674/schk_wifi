/**
 * ValidEffectUserServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.schk.portaltest;

public class ValidEffectUserServiceLocator extends org.apache.axis.client.Service implements ValidEffectUserService {

    public ValidEffectUserServiceLocator() {
    }


    public ValidEffectUserServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ValidEffectUserServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ValidEffectUser
    private String ValidEffectUser_address = "http://172.18.8.42:10000/SINGPOINT/services/ValidEffectUser";

    public String getValidEffectUserAddress() {
        return ValidEffectUser_address;
    }

    // The WSDD service name defaults to the port name.
    private String ValidEffectUserWSDDServiceName = "ValidEffectUser";

    public String getValidEffectUserWSDDServiceName() {
        return ValidEffectUserWSDDServiceName;
    }

    public void setValidEffectUserWSDDServiceName(String name) {
        ValidEffectUserWSDDServiceName = name;
    }

    public ValidEffectUser_PortType getValidEffectUser() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ValidEffectUser_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getValidEffectUser(endpoint);
    }

    public ValidEffectUser_PortType getValidEffectUser(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ValidEffectUserSoapBindingStub _stub = new ValidEffectUserSoapBindingStub(portAddress, this);
            _stub.setPortName(getValidEffectUserWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setValidEffectUserEndpointAddress(String address) {
        ValidEffectUser_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ValidEffectUser_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ValidEffectUserSoapBindingStub _stub = new ValidEffectUserSoapBindingStub(new java.net.URL(ValidEffectUser_address), this);
                _stub.setPortName(getValidEffectUserWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("ValidEffectUser".equals(inputPortName)) {
            return getValidEffectUser();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://172.18.8.42:10000/SINGPOINT/services/ValidEffectUser", "ValidEffectUserService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://172.18.8.42:10000/SINGPOINT/services/ValidEffectUser", "ValidEffectUser"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("ValidEffectUser".equals(portName)) {
            setValidEffectUserEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
