
import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;


public class ConsultazioneSpese extends Application {
    
    private NuovaSpesa nuovaSpesa;
    private TabellaUltimeSpese tabellaSpese;
    private RegistroPerCategoria registroCategoria;
    private DataBaseSpese dataBase;
    private LogXMLAttivita socketDiLog;
    private CacheSpesaNonSalvata cache;
        
    public void start(Stage stage) {
               
        GestoreParametriConfigurazioneXML g = new GestoreParametriConfigurazioneXML("./src/parametri.xml", "./src/parametri.xsd");
        ParametriConfigurazione p = g.getParametri();
        
        File f = new File("./src/cache.bin");
        
        dataBase = new DataBaseSpese(p);
        socketDiLog = new LogXMLAttivita(g);
        socketDiLog.inviaMessaggioLogEvento(TipoLog.AVVIO_APPLICAZIONE);
        cache = new CacheSpesaNonSalvata(f);
        tabellaSpese = new TabellaUltimeSpese(dataBase, socketDiLog, p);
        nuovaSpesa = new NuovaSpesa(dataBase, socketDiLog,tabellaSpese, cache, p);
        registroCategoria = new RegistroPerCategoria(dataBase, socketDiLog, p);
        
      
        
        tabellaSpese.caricaSpese();
        registroCategoria.aggiornaGrafico();
        
        stage.setOnCloseRequest((WindowEvent we) -> {cache.memorizzaSpesaNonSalvata(nuovaSpesa.getSpesa());
                                                    socketDiLog.inviaMessaggioLogEvento(TipoLog.TERMINE_APPLICAZIONE);});
        
        VBox vb = new VBox(nuovaSpesa.getVBox(), tabellaSpese.getVBox(), registroCategoria.getVbox());
        vb.setSpacing(10);
        
        Group root = new Group(vb);
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Registro Spese Giornaliero.");
        stage.setScene(scene);
        stage.show();
    }
    
}
