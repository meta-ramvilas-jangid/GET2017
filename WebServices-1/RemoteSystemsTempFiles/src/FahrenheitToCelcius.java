import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public class FahrenheitToCelcius {
	@WebMethod
	public double fahrenheitToCelciusConvertor(Double f){
		return ((f-32)*5)/9;
		
	}
}
