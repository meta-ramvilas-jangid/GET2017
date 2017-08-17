/**
 * FahrenheitToCelciusServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class FahrenheitToCelciusServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.FahrenheitToCelciusService {

    public FahrenheitToCelciusServiceLocator() {
    }


    public FahrenheitToCelciusServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FahrenheitToCelciusServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FahrenheitToCelcius
    private java.lang.String FahrenheitToCelcius_address = "http://localhost:8080/TempConvertor/services/FahrenheitToCelcius";

    public java.lang.String getFahrenheitToCelciusAddress() {
        return FahrenheitToCelcius_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FahrenheitToCelciusWSDDServiceName = "FahrenheitToCelcius";

    public java.lang.String getFahrenheitToCelciusWSDDServiceName() {
        return FahrenheitToCelciusWSDDServiceName;
    }

    public void setFahrenheitToCelciusWSDDServiceName(java.lang.String name) {
        FahrenheitToCelciusWSDDServiceName = name;
    }

    public DefaultNamespace.FahrenheitToCelcius getFahrenheitToCelcius() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FahrenheitToCelcius_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFahrenheitToCelcius(endpoint);
    }

    public DefaultNamespace.FahrenheitToCelcius getFahrenheitToCelcius(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.FahrenheitToCelciusSoapBindingStub _stub = new DefaultNamespace.FahrenheitToCelciusSoapBindingStub(portAddress, this);
            _stub.setPortName(getFahrenheitToCelciusWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFahrenheitToCelciusEndpointAddress(java.lang.String address) {
        FahrenheitToCelcius_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.FahrenheitToCelcius.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.FahrenheitToCelciusSoapBindingStub _stub = new DefaultNamespace.FahrenheitToCelciusSoapBindingStub(new java.net.URL(FahrenheitToCelcius_address), this);
                _stub.setPortName(getFahrenheitToCelciusWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
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
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FahrenheitToCelcius".equals(inputPortName)) {
            return getFahrenheitToCelcius();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "FahrenheitToCelciusService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "FahrenheitToCelcius"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FahrenheitToCelcius".equals(portName)) {
            setFahrenheitToCelciusEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
