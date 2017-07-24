import java.io.*;

public class ParametriConfigurazione implements Serializable {
    
    private ParametriServer parametriServer;
    private ParametriDataBase parametriDatabase;
    private ParametriStilistici parametriStilistici;    
    
    public ParametriConfigurazione(ParametriServer paramSrvr, ParametriDataBase paramDb, ParametriStilistici stilistici) {
        this.parametriServer = paramSrvr;
        this.parametriDatabase = paramDb;
        this.parametriStilistici = stilistici;
    }
    
    public ParametriServer getParametriServer() {
        return parametriServer;
    }
    
    public ParametriDataBase getParametriDatabase() {
        return parametriDatabase;
    }
    
    public ParametriStilistici getParametriStilistici() {
        return parametriStilistici;
    }
}
