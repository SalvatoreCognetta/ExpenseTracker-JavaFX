import java.time.*;
import java.util.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.chart.*;
import javafx.event.*;
import javafx.geometry.*;

/*
* RegistroPerCategoria: 
*
*/
        
public class RegistroPerCategoria {
    
    private DataBaseSpese database;
    private LogXMLAttivita socketDiLog;
    private ParametriConfigurazione parametriConfig;
    private VBox vboxPrincipale;
    private HBox hboxGrafico;
    private VBox vboxData;
    private Label titolo;
    private PieChart diagramma;
    private ObservableList<PieChart.Data> datiDiagramma;
    private Label lblPeriodo;
    private Label lblDataInizio;
    private DatePicker dataInizio;
    private Label lblDataFine;
    private DatePicker dataFine;
    private Button aggiorna;
    
    public RegistroPerCategoria(DataBaseSpese db, LogXMLAttivita so, ParametriConfigurazione param) {
        this.database = db;
        this.socketDiLog = so;
        this.parametriConfig = param;
        
        vboxPrincipale = new VBox();
        
        titolo = new Label("Registro per categoria");
        
        hboxGrafico = new HBox();
        datiDiagramma = FXCollections.observableArrayList();
        
        diagramma = new PieChart(datiDiagramma);
               
        vboxData = new VBox();
        
        lblPeriodo = new Label("Seleziona periodo da considerare");
        
        lblDataInizio = new Label("Data Inizio:");
        dataInizio = new DatePicker();
        dataInizio.setValue(LocalDate.now());
        
        lblDataFine = new Label("Data Fine:");
        dataFine = new DatePicker();
        dataFine.setValue(LocalDate.now());
        
        aggiorna = new Button("Aggiorna");
        aggiorna.setOnAction((ActionEvent ev) -> {aggiornaGrafico(); socketDiLog.inviaMessaggioLogEvento(TipoLog.CLICK_PULSANTE_AGGIORNA);});
        
        vboxData.getChildren().addAll(lblPeriodo,lblDataInizio, dataInizio, lblDataFine, dataFine, aggiorna);

        hboxGrafico.getChildren().addAll(diagramma, vboxData);

        vboxPrincipale.getChildren().addAll(titolo, hboxGrafico);
        
        setStyle();
    }
    
    public void aggiornaGrafico() {
        List<PieChart.Data> d = database.ottieniStoricoSpese(dataInizio.getValue(), dataFine.getValue());
        if (d.isEmpty()) 
            d.add(new PieChart.Data("Nessun valore", 1));
        datiDiagramma.clear();
        datiDiagramma.addAll(d);
    }
    
    
    public VBox getVbox() {
        return vboxPrincipale;
    }
    
    private void setStyle() {
        String font = parametriConfig.getParametriStilistici().getFont();
        String dimensione = String.valueOf(parametriConfig.getParametriStilistici().getDimensioneFont().getDimensione());
        String unita = parametriConfig.getParametriStilistici().getDimensioneFont().getUnita();
        titolo.setStyle("-fx-font-family: " + font + "; -fx-font-size: " + dimensione + unita);
        hboxGrafico.setStyle("-fx-border-width: 2px; -fx-border-color:grey;");
        vboxData.setStyle("-fx-spacing:10");
        vboxData.setAlignment(Pos.CENTER);
        vboxPrincipale.setSpacing(10);
    }
}
