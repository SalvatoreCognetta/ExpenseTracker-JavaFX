
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salvik
 */
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
            System.out.println(s);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Impossibile prelevare!");
        }
        return s;
    }
    
}
