import javafx.beans.property.*;

/**
 * Spesa: classe bean che incapsula ogni riga del risultato di una query SQL in un oggetto Java. 
 */


public class Spesa {
    
    private final SimpleIntegerProperty idSpesa;    
    private final SimpleDoubleProperty costo;
    private final SimpleStringProperty categoria;
    private final SimpleStringProperty descrizione;
    private final SimpleStringProperty data;

    public Spesa (int id, double costo, String categoria, String descrizione, String data) {
        this.idSpesa = new SimpleIntegerProperty(id);
        this.costo = new SimpleDoubleProperty(costo);
        this.categoria = new SimpleStringProperty(categoria);
        this.descrizione = new SimpleStringProperty(descrizione);
        this.data = new SimpleStringProperty(data);
    }
    
    public int getId() {
        return idSpesa.get();
    }

    public double getCosto() {
        return costo.get();
    }

    public String getCategoria() {
        return categoria.get();
    }

    public String getDescrizione() {
        return descrizione.get();
    }

    public String getData() {
        return data.get();
    }

}