
import java.io.*;
import java.net.*;
import java.nio.file.*;
import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.transform.stream.*;
import javax.xml.validation.*;
import org.xml.sax.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salvik
 */
public class ServerLogXMLAttivita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(ServerSocket servs = new ServerSocket(8080);){
            while(true){
                try(Socket so = servs.accept();
                    DataInputStream din = new DataInputStream(so.getInputStream());){
                    String xml = din.readUTF();
                    validaRigaDiLog(xml);
                }
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public static void validaRigaDiLog(String xml) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema s = sf.newSchema(new StreamSource("./src/messaggioDiLog.xsd"));
            s.newValidator().validate(new StreamSource(new StringReader(xml)));
            Files.write(Paths.get("fileDiLog.txt"), xml.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Validazione effettuata.");
        } catch (Exception ex) {
            if(ex instanceof SAXException)
                System.out.println("Errore di validazione: " + ex.getMessage());
            else
                System.out.println(ex.getMessage());
        }
    }
    
}
