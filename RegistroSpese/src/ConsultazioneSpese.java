
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
               
        ParametriConfigurazione p = new ParametriConfigurazione(new ParametriServer("localhost", 8080), new ParametriDataBase("localhost", "RegistroSpese", 3306, "root", ""),
                new ParametriStilistici("Times New Roman", new DimensioneFont(15, "pt"), 10));
        GestoreParametriConfigurazioneXML g = new GestoreParametriConfigurazioneXML("./src/parametri.xml", "./src/parametri.xsd");
        g.setParametri(p);
        
        File f = new File("./src/cache.bin");
        
        dataBase = new DataBaseSpese(g.getParametri());
        socketDiLog = new LogXMLAttivita(g);
        socketDiLog.inviaMessaggioLogEvento(TipoLog.AVVIO_APPLICAZIONE);
        cache = new CacheSpesaNonSalvata(f);
        tabellaSpese = new TabellaUltimeSpese(dataBase, socketDiLog, g.getParametri());
        nuovaSpesa = new NuovaSpesa(dataBase, socketDiLog,tabellaSpese, cache, g.getParametri());
        registroCategoria = new RegistroPerCategoria(dataBase, socketDiLog, g.getParametri());
        
      
        
        tabellaSpese.caricaSpese();
        registroCategoria.aggiornaGrafico();
        
        stage.setOnCloseRequest((WindowEvent we) -> {cache.memorizzaSpesaNonSalvata(nuovaSpesa.getSpesa());
                                                    socketDiLog.inviaMessaggioLogEvento(TipoLog.TERMINE_APPLICAZIONE);});
        
        VBox vb = new VBox(nuovaSpesa.getVBox(), tabellaSpese.getVBox(), registroCategoria.getVbox());
        vb.setSpacing(20);
        
        Group root = new Group(vb);
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Registro Spese Giornaliero.");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
