import com.thoughtworks.xstream.*;
import java.net.*;
import java.io.*;

/**
 * LogXMLAttivita
 */
public class LogXMLAttivita {

    private Socket sc;
    private DataOutputStream dout;
    private String indirizzoIPServer;
    private int portaServer;

    public LogXMLAttivita (GestoreParametriConfigurazioneXML gestoreParametri) {
        ParametriConfigurazione p = gestoreParametri.getParametri();
        this.indirizzoIPServer = p.getIndirizzoIpSrvr();
        this.portaServer = p.getPortaServer();
        try {
            sc = new Socket(indirizzoIPServer, portaServer);
            dout = new DataOutputStream(sc.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void inviaMessaggioLogEvento(TipoLog evento) {
        MessaggioDiLog m = new MessaggioDiLog(evento);
        System.out.println(serializzaXML(m));
        try {
            dout.writeUTF(serializzaXML(m));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String serializzaXML(MessaggioDiLog m) {
        XStream xs = new XStream();
        String x = xs.toXML(m);
        return x;
    }
}