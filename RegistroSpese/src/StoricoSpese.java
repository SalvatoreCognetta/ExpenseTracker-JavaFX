import javafx.beans.property.*;

/**
 * StoricoSpese: classe bean che incapsula ogni riga del risultato di una query SQL in un oggetto Java. 
 */

public class StoricoSpese {

    private final SimpleDoubleProperty costo;
    private final SimpleStringProperty categoria;

    public StoricoSpese (double costo, String categoria) {
        this.costo = new SimpleDoubleProperty(costo);
        this.categoria = new SimpleStringProperty(categoria);
    }

    public double getCosto() {
        return costo.get();
    }

    public String getCategoria() {
        return categoria.get();
    }
}