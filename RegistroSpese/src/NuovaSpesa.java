import java.time.LocalDate;
import java.time.format.*;
import java.util.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.util.converter.LocalDateStringConverter;

/**
 * NuovaSpesa: 
 *
 */
public class NuovaSpesa {
    
    private DataBaseSpese dataBase;
    private LogXMLAttivita serverDiLog;
    private CacheSpesaNonSalvata cache;
    private TabellaUltimeSpese tb;
    private VBox vboxprincipale;
    private HBox hboxInserimento;
    private HBox hboxBtn;
    private Label titolo;
    private TextField costoSpesa;
    private ComboBox categoriaSpesa;
    private ObservableList<String> opzioniComboBox;
    private TextField descrizioneSpesa;
    private DatePicker dataSpesa;
    private Button btnAnnulla;
    private Button btnSalva;
    
    public NuovaSpesa(DataBaseSpese db, LogXMLAttivita srvr, TabellaUltimeSpese tb, CacheSpesaNonSalvata cache) {
        this.dataBase = db;
        this.serverDiLog = srvr;
        this.tb = tb;
        this.cache = cache;
        
        String[] spesa = cache.prelevaSpesaNonSalvata();
        titolo = new Label("Inserisci una nuova spesa");
        
        costoSpesa = new TextField();
        costoSpesa.setPromptText("0.00€");

        if(spesa[0] != null)
            costoSpesa.setText(spesa[0]);
        

        opzioniComboBox = FXCollections.observableArrayList();
        opzioniComboBox.addAll(db.ottieniCategorie());
        categoriaSpesa = new ComboBox(opzioniComboBox);
        categoriaSpesa.setPromptText("Categoria");
        if(spesa[1] != null)
            categoriaSpesa.setValue(spesa[1]);

        
        descrizioneSpesa = new TextField();
        descrizioneSpesa.setPromptText("Descrizione");
        if(spesa[2] != null)
            descrizioneSpesa.setText(spesa[2]);
        
        dataSpesa = new DatePicker();
        if(spesa[3] == null)
            dataSpesa.setPromptText(LocalDate.now().toString());
        else
            dataSpesa.setValue(LocalDate.parse(spesa[3]));
        
        hboxInserimento = new HBox();
        //inserire lo spacing tra i children dell'hbox
        hboxInserimento.getChildren().addAll(costoSpesa, categoriaSpesa, descrizioneSpesa, dataSpesa);
        
        btnAnnulla = new Button("Annulla");
        btnAnnulla.setStyle("-fx-color:red");
        btnAnnulla.setOnAction((ActionEvent ev) -> {annullaInserimento();});
        
        btnSalva = new Button("Salva");
        btnSalva.setStyle("-fx-color:blue");
        btnSalva.setOnAction((ActionEvent ev) -> {salvaSpesa();});
        System.out.println("NuovaSpesa.init"+dataSpesa.getValue());
        
        hboxBtn = new HBox();
        hboxBtn.getChildren().addAll(btnAnnulla, btnSalva);
        
        vboxprincipale = new VBox();
        vboxprincipale.getChildren().addAll(titolo, hboxInserimento, hboxBtn);
    }
    
    private void annullaInserimento() {
        costoSpesa.setText("");
        descrizioneSpesa.setText("");
        System.out.println("Campi puliti.");
    }
    
    private void salvaSpesa() {
        double costo = Double.parseDouble(costoSpesa.getText());
        String categoria = (String)categoriaSpesa.getValue();
        String descrizione = descrizioneSpesa.getText();
       
        
        LocalDate data = dataSpesa.getValue();
                
        dataBase.aggiungiSpesa(costo, categoria, descrizione, data);
        
        tb.caricaSpese();
    }
    
    public VBox getVBox() {
        return vboxprincipale;
    }
    
    public String[] getSpesa() {
        String[] l = new String[]{ 
            costoSpesa.getText(),
            categoriaSpesa.getValue() == null ? null : categoriaSpesa.getValue().toString(),
            descrizioneSpesa.getText(),
            dataSpesa.getValue()== null ? null : dataSpesa.getValue().toString()
        };
        for(int i = 0; i < 4; i++)
            System.out.println("NuovaSpesa.getSpesa()"+l[i]);
        return l;
    }
    
}
