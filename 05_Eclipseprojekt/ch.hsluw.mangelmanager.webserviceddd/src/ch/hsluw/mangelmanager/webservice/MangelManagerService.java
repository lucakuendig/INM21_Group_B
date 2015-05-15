/**
 * 
 */
package ch.hsluw.mangelmanager.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ch.hsluw.mangelmanager.model.Login;

/**
 * @author Luca
 *
 */

@WebService
public interface MangelManagerService {
	
	@WebMethod
	Login getLoginByName(@WebParam(name = "name")String name) throws Exception;
	
}
