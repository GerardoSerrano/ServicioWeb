/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Admin
 */
public class LeerXml {
    
     public static ArrayList leer(String valor) {
        ArrayList arraydatos = new ArrayList();

        try {

            File archivo = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\ServicioWeb\\web\\xml\\datos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);

            doc.getDocumentElement().normalize();

            NodeList datos = doc.getElementsByTagName("codigo");

            for (int i = 0; i < datos.getLength(); i++) {

                Node n = datos.item(i);

                System.out.println("\n");

                if (n.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) n;

                    System.out.println("Codigo postal : " + elemento.getAttribute("id"));
                    System.out.println("Localidad : " + elemento.getElementsByTagName("localidad").item(0).getTextContent());
                    System.out.println("Entidad Federativa : " + elemento.getElementsByTagName("entidad").item(0).getTextContent());
                    System.out.println("Asentamientos : " + elemento.getElementsByTagName("asentamiento").item(0).getTextContent());

                    System.out.println("valor = " + valor);
                    if (valor.equals(elemento.getAttribute("id"))) {
                        arraydatos.add("<br><br>Codigo postal : " + elemento.getAttribute("id"));
                        arraydatos.add("<br>Localidad : " + elemento.getElementsByTagName("localidad").item(0).getTextContent());
                        arraydatos.add("<br>Entidad : " + elemento.getElementsByTagName("entidad").item(0).getTextContent());
                        arraydatos.add("<br>Asentamiento : " + elemento.getElementsByTagName("asentamiento").item(0).getTextContent());
                    }
                }

                System.out.println("arraydatos = " + arraydatos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arraydatos;
    }
    
}
