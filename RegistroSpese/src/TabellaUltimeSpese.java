import java.util.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.*;
import javafx.event.*;


/**
 * TabellaUltimeSpese: classe che rappresenta la parte centrale dell'applicativo, contenente la tabella delle ultime spese e la possibilità di eliminazione di 
 * una di esse tramite un button 'Elimina'.
 */

public class TabellaUltimeSpese {

    private DataBaseSpese dataBase;
    private LogXMLAttivita serverDiLog;
    private VBox vbox;
    private Label titolo;
    private TableView<Spesa> table;
    private ObservableList<Spesa> listaSpese;
    private Button eliminaSpesa;
    private int maxRecord;

    public TabellaUltimeSpese (DataBaseSpese db, LogXMLAttivita srvr, int maxRecord) {
        dataBase = db;
        serverDiLog = srvr;
        this.maxRecord = maxRecord;
        
        titolo = new Label("UltimeSpese");
        //aggiungere il set font
        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setMinWidth(480);
        //aggiungere il set del numero massimo di item visibili
        
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
        
        eliminaSpesa = new Button("Elimina");
        //aggiungere allineamento
        eliminaSpesa.setOnAction((ActionEvent ev) -> {eliminaSpesa();});
        
        vbox = new VBox();
        vbox.getChildren().addAll(titolo, table, eliminaSpesa);
    }

    public void caricaSpese() {
        List<Spesa> spese = dataBase.ottieniListaSpese();
        listaSpese.clear();
        listaSpese.addAll(spese);
    }
    
    public void eliminaSpesa() {
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


}
