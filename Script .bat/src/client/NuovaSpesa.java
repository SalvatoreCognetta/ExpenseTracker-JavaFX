import java.time.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.*;

/**
 * NuovaSpesa: 
 *
 */
public class NuovaSpesa {
    
    private DataBaseSpese dataBase;
    private LogXMLAttivita socketDiLog;
    private CacheSpesaNonSalvata cache;
    private ParametriConfigurazione parametriConfig;
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
    
    public NuovaSpesa(DataBaseSpese db, LogXMLAttivita so, TabellaUltimeSpese tb, CacheSpesaNonSalvata cache, ParametriConfigurazione param) {
        this.dataBase = db;
        this.socketDiLog = so;
        this.tb = tb;
        this.cache = cache;
        this.parametriConfig = param;
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
        hboxInserimento.getChildren().addAll(costoSpesa, categoriaSpesa, descrizioneSpesa, dataSpesa);
        btnAnnulla = new Button("Annulla");
        btnAnnulla.setOnAction((ActionEvent ev) -> {annullaInserimento(); socketDiLog.inviaMessaggioLogEvento(TipoLog.CLICK_PULSANTE_ANNULLA);});
        
        btnSalva = new Button("Salva");
        btnSalva.setOnAction((ActionEvent ev) -> {salvaSpesa(); socketDiLog.inviaMessaggioLogEvento(TipoLog.CLICK_PULSANTE_SALVA);});
        
        hboxBtn = new HBox();
        hboxBtn.getChildren().addAll(btnAnnulla, btnSalva);
        vboxprincipale = new VBox();
        vboxprincipale.getChildren().addAll(titolo, hboxInserimento, hboxBtn);
        setStyle();
    }
    
    private void annullaInserimento() {
        costoSpesa.setText("");
        categoriaSpesa.setValue(null);
        descrizioneSpesa.setText("");
        dataSpesa.setValue(null);
        System.out.println("Campi puliti.");
    }
    
    private void salvaSpesa() {
        double costo;
        String categoria;
        LocalDate data;
        
        if(!costoSpesa.getText().isEmpty())
            costo = Double.parseDouble(costoSpesa.getText());
        else {
            System.out.println("Impossibile salvare la spesa, manca il parametro costo.");
            return;
        }
        
        if(categoriaSpesa.getValue() != null)
            categoria = categoriaSpesa.getValue().toString();
        else {
            System.out.println("Impossibile salvare la spesa, manca il parametro categoria.");
            return;
        }
        
        String descrizione = descrizioneSpesa.getText();
        
        if(dataSpesa.getValue() != null)
            data = dataSpesa.getValue();
        else
            data = LocalDate.now();
        
        dataBase.aggiungiSpesa(costo, categoria, descrizione, data);
        tb.caricaSpese();
        annullaInserimento();
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
        return l;
    }
    
    private void setStyle() {
        String font = parametriConfig.getParametriStilistici().getFont();
        String dimensione = String.valueOf(parametriConfig.getParametriStilistici().getDimensioneFont().getDimensione());
        String unita = parametriConfig.getParametriStilistici().getDimensioneFont().getUnita();
        titolo.setStyle("-fx-font-family: " + font + "; -fx-font-size: " + dimensione + unita);
        hboxInserimento.setStyle("-fx-border-width: 2px; -fx-border-color: #5592f4; -fx-spacing:10; -fx-border-radius: 5px; ");
        hboxInserimento.setMinSize(50, 55);
        btnAnnulla.setStyle("-fx-color: #d13e3e");
        btnSalva.setStyle("-fx-color: #3a6cb7");
        hboxBtn.setAlignment(Pos.CENTER);
        hboxBtn.setSpacing(10);
        hboxInserimento.setAlignment(Pos.CENTER);
        vboxprincipale.setStyle("-fx-spacing:10;");

    }
    
}
