/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import xml.LeerXml;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "servicio")
public class servicio {

    /**
     * Web service operation
     */
@WebMethod(operationName = "envio")
    public ArrayList envio(@WebParam(name = "parameter") String parameter) {
        //TODO write your implementation code here:
        System.out.println("parameter ok = " + parameter);

        LeerXml leerXml = new LeerXml();
        
        ArrayList datos =  leerXml.leer(parameter);
        System.out.println("datos = " + datos);
   
        return datos;
   
    }
}
