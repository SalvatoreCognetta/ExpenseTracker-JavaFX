import java.time.LocalDate;
import java.util.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.chart.*;
import javafx.event.*;

/*
* RegistroPerCategoria: 
*
*/
        
public class RegistroPerCategoria {
    
    private DataBaseSpese database;
    private LogXMLAttivita serverDiLog;
    private VBox vboxPrincipale;
    private HBox hboxGrafico;
    private VBox vboxData;
    private Label titolo;
    private PieChart diagramma;
    private ObservableList<PieChart.Data> datiDiagramma;
    private Label lblPeriodo;
    private DatePicker dataInizio;
    private DatePicker dataFine;
    private Button aggiorna;
    
    public RegistroPerCategoria(DataBaseSpese db, LogXMLAttivita srvr) {
        this.database = db;
        this.serverDiLog = srvr;
        
        vboxPrincipale = new VBox();
        
        titolo = new Label("Registro per categoria");
        
        hboxGrafico = new HBox();
        datiDiagramma = FXCollections.observableArrayList();
        
      
        diagramma = new PieChart(datiDiagramma);
        
        
        vboxData = new VBox();
        lblPeriodo = new Label("Seleziona periodo da considerare");
        dataInizio = new DatePicker();
        dataInizio.setValue(LocalDate.now());
        dataFine = new DatePicker();
        dataFine.setValue(LocalDate.now());
        aggiorna = new Button("Aggiorna");
        
        aggiorna.setOnAction((ActionEvent ev) -> {aggiornaGrafico();});
        
        vboxData.getChildren().addAll(lblPeriodo, dataInizio, dataFine, aggiorna);
        hboxGrafico.getChildren().addAll(diagramma, vboxData);
        vboxPrincipale.getChildren().addAll(titolo, hboxGrafico);
        
        
    }
    
    public void aggiornaGrafico() {
        List<PieChart.Data> d = database.ottieniStoricoSpese(dataInizio.getValue(), dataFine.getValue());
        if (d.isEmpty()) 
            d.add(new PieChart.Data("Nessun valore", 1));
        datiDiagramma.clear();
        datiDiagramma.addAll(d);
        System.out.println("RegistroPerCategoria.aggiornaGrafico"+d);
    }
    
    
    public VBox getVbox() {
        return vboxPrincipale;
    }
}
