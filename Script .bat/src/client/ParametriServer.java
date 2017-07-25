
import java.io.*;


public class ParametriServer implements Serializable {
    
    private String indirizzoIPServerDiLog;
    private int portaServerDiLog;
    
    public ParametriServer(String ind, int porta) {
        this.indirizzoIPServerDiLog = ind;
        this.portaServerDiLog = porta;
    }
    
    public String getIndirizzoIpSrvr() {
        return indirizzoIPServerDiLog;
    }
    
    public int getPortaServer() {
        return portaServerDiLog;
    }
    
}
