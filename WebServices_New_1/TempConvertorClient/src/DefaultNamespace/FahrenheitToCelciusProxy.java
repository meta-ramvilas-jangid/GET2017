package DefaultNamespace;

public class FahrenheitToCelciusProxy implements DefaultNamespace.FahrenheitToCelcius {
  private String _endpoint = null;
  private DefaultNamespace.FahrenheitToCelcius fahrenheitToCelcius = null;
  
  public FahrenheitToCelciusProxy() {
    _initFahrenheitToCelciusProxy();
  }
  
  public FahrenheitToCelciusProxy(String endpoint) {
    _endpoint = endpoint;
    _initFahrenheitToCelciusProxy();
  }
  
  private void _initFahrenheitToCelciusProxy() {
    try {
      fahrenheitToCelcius = (new DefaultNamespace.FahrenheitToCelciusServiceLocator()).getFahrenheitToCelcius();
      if (fahrenheitToCelcius != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fahrenheitToCelcius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fahrenheitToCelcius)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fahrenheitToCelcius != null)
      ((javax.xml.rpc.Stub)fahrenheitToCelcius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.FahrenheitToCelcius getFahrenheitToCelcius() {
    if (fahrenheitToCelcius == null)
      _initFahrenheitToCelciusProxy();
    return fahrenheitToCelcius;
  }
  
  public double fahrenheitToCelciusConvertor(double f) throws java.rmi.RemoteException{
    if (fahrenheitToCelcius == null)
      _initFahrenheitToCelciusProxy();
    return fahrenheitToCelcius.fahrenheitToCelciusConvertor(f);
  }
  
  
}