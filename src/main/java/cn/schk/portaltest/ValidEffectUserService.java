/**
 * ValidEffectUserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.schk.portaltest;

public interface ValidEffectUserService extends javax.xml.rpc.Service {
	
    public java.lang.String getValidEffectUserAddress();

    public cn.schk.portaltest.ValidEffectUser_PortType getValidEffectUser() throws javax.xml.rpc.ServiceException;

    public cn.schk.portaltest.ValidEffectUser_PortType getValidEffectUser(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
