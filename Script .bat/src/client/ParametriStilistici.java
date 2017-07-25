
import java.io.*;


public class ParametriStilistici implements Serializable {
        
    private String font;
    private DimensioneFont dimensioneFont;
    private int maxRecord;
    
    public ParametriStilistici(String font, DimensioneFont df, int numRecord) {
        this.font = font;
        this.dimensioneFont = df;
        this.maxRecord = numRecord;
    }
    
    public String getFont() {
        return font;
    }
    
    public int getMaxRecord() {
        return maxRecord;
    }
    
    public DimensioneFont getDimensioneFont() {
        return dimensioneFont;
    }
}
