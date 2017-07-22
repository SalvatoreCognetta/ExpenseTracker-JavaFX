
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
        ParametriConfigurazione p = new ParametriConfigurazione("localhost", 8080, "localhost", "RegistroSpese", 3306, "root", "", "pt", "font", 0, 0);
        GestoreParametriConfigurazioneXML g = new GestoreParametriConfigurazioneXML("test.txt", "test.xsd");
        g.setParametri(p);
        
        File f = new File("./cache.bin");
        
        dataBase = new DataBaseSpese(g);
        serverDiLog = new LogXMLAttivita(g);
        cache = new CacheSpesaNonSalvata(f);
        tabellaSpese = new TabellaUltimeSpese(dataBase, serverDiLog, 10);
        nuovaSpesa = new NuovaSpesa(dataBase, serverDiLog,tabellaSpese, cache);
        registroCategoria = new RegistroPerCategoria(dataBase, serverDiLog);
        
      
        
        tabellaSpese.caricaSpese();
        registroCategoria.aggiornaGrafico();
        
        stage.setOnCloseRequest((WindowEvent we) -> {cache.memorizzaSpesaNonSalvata(nuovaSpesa.getSpesa());
                                                    serverDiLog.inviaMessaggioLogEvento(TipoLog.TERMINE_APPLICAZIONE);});
//stage.setOnCloseRequest((WindowEvent we) ­> {cache.memorizzaSpesaNonSalvata(nuovaSpesa.getSpesa());});
        
        VBox vb = new VBox(nuovaSpesa.getVBox(), tabellaSpese.getVBox(), registroCategoria.getVbox());
        
        Scene scene = new Scene(new Group(vb));
        stage.setTitle("Registro Spese Giornaliero.");
        stage.setScene(scene);
        stage.show();
    }
}
