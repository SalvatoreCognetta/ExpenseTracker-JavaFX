
import com.thoughtworks.xstream.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.validation.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import com.thoughtworks.xstream.converters.basic.*;
        
public class GestoreParametriConfigurazioneXML {
    
    private static String pathFileConfigurazione;
    private static String pathFileXSDConfigurazione;
    private ParametriConfigurazione parametri;
    
    public GestoreParametriConfigurazioneXML(String pathFileConfig, String pathFileXSD) {
        this.pathFileConfigurazione = pathFileConfig;
        this.pathFileXSDConfigurazione = pathFileXSD;
    }
   
    
    public void validaFileDiConfigurazione() {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Document d = db.parse(pathFileConfigurazione);
            Schema s = sf.newSchema(new StreamSource(pathFileXSDConfigurazione));
            s.newValidator().validate(new DOMSource(d));
        } catch (Exception ex) {
            if(ex instanceof SAXException)
                System.out.println("Errore di validazione: " + ex.getMessage());
            else
                System.out.println(ex.getMessage());
        }
    }
    
    public void setParametri(ParametriConfigurazione p) {
        XStream xs = new XStream();
        xs.processAnnotations(DimensioneFont.class);
        String x = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+xs.toXML(p)+"\n";
        try {
            Files.write(Paths.get(pathFileConfigurazione), x.getBytes());
            validaFileDiConfigurazione();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public ParametriConfigurazione getParametri() {
        validaFileDiConfigurazione();
        XStream xs = new XStream();
        xs.processAnnotations(DimensioneFont.class);
        String x = null;
        try {
            x = new String(Files.readAllBytes(Paths.get(pathFileConfigurazione)));
        } catch (IOException ex) {
            ex.printStackTrace();            
        }
        parametri = (ParametriConfigurazione)xs.fromXML(x);
        return parametri; 
    }
   
   
}
