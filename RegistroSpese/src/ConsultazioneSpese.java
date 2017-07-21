
import java.io.File;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.VBox;


public class ConsultazioneSpese extends Application {
    
    private NuovaSpesa nuovaSpesa;
    private TabellaUltimeSpese tabellaSpese;
    private RegistroPerCategoria registroCategoria;
    private DataBaseSpese dataBase;
    private LogXMLAttivita serverDiLog;
    private CacheSpesaNonSalvata cache;
        
    public void start(Stage stage) {
        File f = new File("./test.bin");
        
        dataBase = new DataBaseSpese("localhost", "3306", "RegistroSpese");
        serverDiLog = new LogXMLAttivita();
        cache = new CacheSpesaNonSalvata(f);
        tabellaSpese = new TabellaUltimeSpese(dataBase, serverDiLog, 10);
        nuovaSpesa = new NuovaSpesa(dataBase, serverDiLog,tabellaSpese, cache);
        registroCategoria = new RegistroPerCategoria(dataBase, serverDiLog);
        
        
        tabellaSpese.caricaSpese();
        registroCategoria.aggiornaGrafico();
        
        stage.setOnCloseRequest((WindowEvent we) -> {cache.memorizzaSpesaNonSalvata(nuovaSpesa.getCosto());});
//stage.setOnCloseRequest((WindowEvent we) ­> {cache.memorizzaSpesaNonSalvata(nuovaSpesa.getSpesa());});
        
        VBox vb = new VBox(nuovaSpesa.getVBox(), tabellaSpese.getVBox(), registroCategoria.getVbox());
        
        Scene scene = new Scene(new Group(vb));
        stage.setTitle("Registro Spese Giornaliero.");
        stage.setScene(scene);
        stage.show();
    }
}
