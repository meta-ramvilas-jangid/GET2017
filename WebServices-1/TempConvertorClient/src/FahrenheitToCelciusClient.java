import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import DefaultNamespace.FahrenheitToCelcius;
import DefaultNamespace.FahrenheitToCelciusServiceLocator;

public class FahrenheitToCelciusClient {

	public static double main(Double f) {
		// TODO Auto-generated method stub
		
		FahrenheitToCelciusServiceLocator locator =new FahrenheitToCelciusServiceLocator();
		locator.setFahrenheitToCelciusEndpointAddress("http://localhost:8080/TempConvertor/services/FahrenheitToCelcius");
		double celcius=0.0;
		try {
			FahrenheitToCelcius result=locator.getFahrenheitToCelcius();
			celcius=result.fahrenheitToCelciusConvertor(f);
			System.out.println( Math.round(celcius * 100.0) / 100.0);
		} catch (ServiceException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Math.round(celcius * 100.0) / 100.0;

	}

}













