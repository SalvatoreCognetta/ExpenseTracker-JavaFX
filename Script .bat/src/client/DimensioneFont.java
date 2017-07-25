
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import java.io.Serializable;

@XStreamAlias("dimensioneFont")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"dimensione"})
public class DimensioneFont implements Serializable {
    
    private int dimensione;
    @XStreamAlias("unita")
    private String unita;
    
    public DimensioneFont(int dim, String unita) {
        this.dimensione = dim; 
        this.unita = unita;
    }
    
    
    public int getDimensione() {
        return dimensione;
    }
    
    public String getUnita() {
        return unita;
    }
    
}
