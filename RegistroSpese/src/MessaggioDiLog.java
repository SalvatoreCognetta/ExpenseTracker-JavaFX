
import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;


public class MessaggioDiLog implements Serializable {
    
    private TipoLog evento;
    private String indirizzoIP;
    private String nomeApplicazione = "Registro Spese";
    private Date data; 
    private String ora;
    
    public MessaggioDiLog(TipoLog e, String ipClient) {
        this.evento = e;
        try {
            this.data = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
            this.ora = String.format("%02d:%02d:%02d", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(),LocalDateTime.now().getSecond());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.indirizzoIP = ipClient;
    }
}
