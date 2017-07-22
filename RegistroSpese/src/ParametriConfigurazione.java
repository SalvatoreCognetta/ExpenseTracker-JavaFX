import java.io.Serializable;

public class ParametriConfigurazione implements Serializable{
    
    private String indirizzoIPServerDiLog;
    private int portaServerDiLog;
    private String indirizzoIPDatabase;    
    private int portaDatabase;
    private String nomeDatabase;
    private String usernameDatabase;
    private String passwordDatabase;
    private String unita;
    private String font;
    private int dimensione;
    private int maxRecord;
    
    public ParametriConfigurazione(String indIPSrvr, int portaSrvr, String indIPDb, String nomeDb, int portaDb, String username, String pwd,String unita, String font, int dim, int numRecord) {
        this.indirizzoIPDatabase = indIPSrvr;
        this.portaServerDiLog = portaSrvr;
        this.indirizzoIPDatabase = indIPDb;
        this.portaDatabase = portaDb;
        this.nomeDatabase = nomeDb;
        this.usernameDatabase = username;
        this.passwordDatabase = pwd;
        this.unita = unita;
        this.font = font;
        this.dimensione = dim;
        this.maxRecord = numRecord;
    }
    
    public String getIndirizzoIpSrvr() {
        return indirizzoIPServerDiLog;
    }
    
    public int getPortaServer() {
        return portaServerDiLog;
    }
    
    public String getIndirizzoIpDb() {
        return indirizzoIPDatabase;
    }
    
    public int getPortaDb() {
        return portaDatabase;
    }
    
    public String getNomeDb() {
        return nomeDatabase;
    }
    
    public String getUsernameDb() {
        return usernameDatabase;
    }
    
    public String getPwdDb() {
        return passwordDatabase;
    }
}
