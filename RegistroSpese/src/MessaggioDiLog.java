
import java.time.LocalDate;


public class MessaggioDiLog {
    
    private TipoLog evento;
    private String data; //oppure LocalDate?
    
    public MessaggioDiLog(TipoLog e) {
        this.evento = e;
        this.data = LocalDate.now().toString();
    }
}
