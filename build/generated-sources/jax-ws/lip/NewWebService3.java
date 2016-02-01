
package lip;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NewWebService3", targetNamespace = "http://lip/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NewWebService3 {


    /**
     * 
     * @param sporocilo
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "operation", targetNamespace = "http://lip/", className = "lip.Operation")
    @ResponseWrapper(localName = "operationResponse", targetNamespace = "http://lip/", className = "lip.OperationResponse")
    @Action(input = "http://lip/NewWebService3/operationRequest", output = "http://lip/NewWebService3/operationResponse")
    public String operation(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "sporocilo", targetNamespace = "")
        String sporocilo);

}