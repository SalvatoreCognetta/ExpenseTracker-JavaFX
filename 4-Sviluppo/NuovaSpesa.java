import java.time.LocalDate;
import java.time.format.*;
import java.util.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

/**
 * NuovaSpesa: 
 *
 */
public class NuovaSpesa {
    
    private DataBaseSpese dataBase;
    private LogXMLAttivita serverDiLog;
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
    
    public NuovaSpesa(DataBaseSpese db, LogXMLAttivita srvr, TabellaUltimeSpese tb/*, CacheSpesaNonSalvata cache*/) {
        this.dataBase = db;
        this.serverDiLog = srvr;
        this.tb = tb;
        
        titolo = new Label("Inserisci una nuova spesa");
        
        costoSpesa = new TextField();
        costoSpesa.setPromptText("0.00€");
        
        opzioniComboBox = FXCollections.observableArrayList();
        opzioniComboBox.addAll(db.ottieniCategorie());
        categoriaSpesa = new ComboBox(opzioniComboBox);
        categoriaSpesa.setPromptText("Categoria");
        
        descrizioneSpesa = new TextField();
        descrizioneSpesa.setPromptText("Descrizione");
        
        dataSpesa = new DatePicker();
        dataSpesa.setValue(LocalDate.now());
        
        hboxInserimento = new HBox();
        //inserire lo spacing tra i children dell'hbox
        hboxInserimento.getChildren().addAll(costoSpesa, categoriaSpesa, descrizioneSpesa, dataSpesa);
        
        btnAnnulla = new Button("Annulla");
        btnAnnulla.setStyle("-fx-color:red");
        btnAnnulla.setOnAction((ActionEvent ev) -> {annullaInserimento();});
        
        btnSalva = new Button("Salva");
        btnSalva.setStyle("-fx-color:blue");
        btnSalva.setOnAction((ActionEvent ev) -> {salvaSpesa();});
        System.out.println(dataSpesa.getValue());
        
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String data = dataSpesa.getValue().format(formatter);
        System.out.println(data);
                
        dataBase.aggiungiSpesa(costo, categoria, descrizione, data);
        
        tb.caricaSpese();
    }
    
    public VBox getVBox() {
        return vboxprincipale;
    }
}
