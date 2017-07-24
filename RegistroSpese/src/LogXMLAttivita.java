import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.converters.basic.*;
import java.net.*;
import java.io.*;

/**
 * LogXMLAttivita
 */
public class LogXMLAttivita {

    private String indirizzoIPServer;
    private int portaServer;

    public LogXMLAttivita (GestoreParametriConfigurazioneXML gestoreParametri) {
        ParametriConfigurazione p = gestoreParametri.getParametri();
        this.indirizzoIPServer = p.getParametriServer().getIndirizzoIpSrvr();
        this.portaServer = p.getParametriServer().getPortaServer();
    }

    public void inviaMessaggioLogEvento(TipoLog evento) {
        
        try(Socket s = new Socket(indirizzoIPServer, portaServer);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());) {
            MessaggioDiLog m = new MessaggioDiLog(evento, InetAddress.getLocalHost().getHostAddress());

            dout.writeUTF("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+serializzaXML(m)+"\n\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String serializzaXML(MessaggioDiLog m) {
        XStream xs = new XStream();
        xs.useAttributeFor(MessaggioDiLog.class, "evento");
        xs.registerConverter(new DateConverter("yyyy-MM-dd", null));
        String x = xs.toXML(m);
        return x;
    }
}