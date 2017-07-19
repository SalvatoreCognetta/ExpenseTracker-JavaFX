
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.VBox;


public class ConsultazioneSpese extends Application {
    
    private NuovaSpesa nuovaSpesa;
    private TabellaUltimeSpese tabellaSpese;
    //private RegistroPerCategoria registroCategoria;
    private DataBaseSpese dataBase;
    private LogXMLAttivita serverDiLog;
    //private CacheSpesaNonSalvata cache;
        
    public void start(Stage stage) {
        dataBase = new DataBaseSpese("localhost", "3306", "RegistroSpese");
        serverDiLog = new LogXMLAttivita();
        tabellaSpese = new TabellaUltimeSpese(dataBase, serverDiLog, 10);
        nuovaSpesa = new NuovaSpesa(dataBase, serverDiLog,tabellaSpese);
        tabellaSpese.caricaSpese();
        
        VBox vb = new VBox(nuovaSpesa.getVBox(), tabellaSpese.getVBox());
        
        Scene scene = new Scene(new Group(vb));
        stage.setTitle("Registro Spese Giornaliero.");
        stage.setScene(scene);
        stage.show();
    }
}
