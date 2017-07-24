
import java.io.*;


public class CacheSpesaNonSalvata {
    
    private static File fileCacheSpesa;
    
    
    public CacheSpesaNonSalvata(File f) {
        fileCacheSpesa = f;
    }
    
    public void memorizzaSpesaNonSalvata(String[] spesa) {
        try(FileOutputStream writerFile = new FileOutputStream(fileCacheSpesa);
            ObjectOutputStream oout = new ObjectOutputStream(writerFile);) {
            for(int i = 0; i < spesa.length; i++)
                oout.writeObject(spesa[i]);
        } catch (IOException ex) {
            System.err.println("Impossibile conservare la spesa!");
            ex.printStackTrace();
        }
    }
    
    public String[] prelevaSpesaNonSalvata() {
        String[] s = new String[4];
        try(FileInputStream readerFile = new FileInputStream(fileCacheSpesa);
            ObjectInputStream oin = new ObjectInputStream(readerFile);) {
            for(int i = 0; i < 4; i++)
                s[i] = (String)oin.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Impossibile prelevare!");
        }
        return s;
    }
    
}
