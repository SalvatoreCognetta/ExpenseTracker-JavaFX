import java.util.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.*;
import javafx.event.*;
import javafx.geometry.*;


/**
 * TabellaUltimeSpese: classe che rappresenta la parte centrale dell'applicativo, contenente la tabella delle ultime spese e la possibilità di eliminazione di 
 * una di esse tramite un button 'Elimina'.
 */

public class TabellaUltimeSpese {

    private DataBaseSpese dataBase;
    private LogXMLAttivita socketDiLog;
    private ParametriConfigurazione parametriConfig;
    private VBox vbox;
    private Label titolo;
    private TableView<Spesa> table;
    private ObservableList<Spesa> listaSpese;
    private Button btnEliminaSpesa;

    public TabellaUltimeSpese (DataBaseSpese db, LogXMLAttivita so, ParametriConfigurazione param) {
        this.dataBase = db;
        this.socketDiLog = so;
        this.parametriConfig = param;
        
        titolo = new Label("UltimeSpese");
        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        TableColumn descrizioneCol = new TableColumn("Descrizione Spesa");
        descrizioneCol.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
        
        TableColumn categoriaCol = new TableColumn("Categoria");
        categoriaCol.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        
        TableColumn costoCol = new TableColumn("Costo");
        costoCol.setCellValueFactory(new PropertyValueFactory<>("costo"));
        
        TableColumn dataCol = new TableColumn("Data");
        dataCol.setCellValueFactory(new PropertyValueFactory<>("data"));
        
        listaSpese = FXCollections.observableArrayList();

        table.setItems(listaSpese);
        table.getColumns().addAll(descrizioneCol, categoriaCol, costoCol, dataCol);
        table.setOnMouseClicked((event) -> {socketDiLog.inviaMessaggioLogEvento(TipoLog.CLICK_TABELLA_ULTIME_SPESE);});
        
        btnEliminaSpesa = new Button("Elimina");
        btnEliminaSpesa.setOnAction((ActionEvent ev) -> {eliminaSpesa(); socketDiLog.inviaMessaggioLogEvento(TipoLog.CLICK_PULSANTE_ELIMINA);});
        
        vbox = new VBox();
        vbox.getChildren().addAll(titolo, table, btnEliminaSpesa);
        setStyle();
    }

    public void caricaSpese() {
        List<Spesa> spese = dataBase.ottieniListaSpese();
        listaSpese.clear();
        listaSpese.addAll(spese);
    }
    
    private void eliminaSpesa() {
        Spesa tmp = table.getSelectionModel().getSelectedItem();
        if (tmp == null)
            System.out.println("Nessuna spesa selezionata.");
        else {
            System.out.println("Eliminata la spesa nr°: " + tmp.getId());
            dataBase.eliminaSpesa(tmp.getId());
        }
        
        caricaSpese();  
    }
    
    public VBox getVBox() {
        return vbox;
    }
    
    private void setStyle() {
        String font = parametriConfig.getParametriStilistici().getFont();
        String dimensione = String.valueOf(parametriConfig.getParametriStilistici().getDimensioneFont().getDimensione());
        String unita = parametriConfig.getParametriStilistici().getDimensioneFont().getUnita();
        titolo.setStyle("-fx-font-family: " + font + "; -fx-font-size: " + dimensione + unita);
        vbox.setSpacing(10);
        table.setMinHeight(150);
        table.setMaxHeight(150);
        btnEliminaSpesa.setStyle("-fx-color: #d13e3e");
        vbox.setAlignment(Pos.CENTER);

    }


}
