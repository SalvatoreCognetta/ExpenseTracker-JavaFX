
import java.io.*;
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
    
    private FileOutputStream writerFile;
    private ObjectOutputStream oout;
    private FileInputStream readerFile;
    private ObjectInputStream oin;
    private File fileCacheSpesa;
    
    public CacheSpesaNonSalvata(File f) {
        fileCacheSpesa = f;
        try {
            writerFile = new FileOutputStream(fileCacheSpesa);
            oout = new ObjectOutputStream(writerFile);
            readerFile = new FileInputStream(fileCacheSpesa);
            oin = new ObjectInputStream(readerFile);
        } catch (IOException e) {
            System.err.println("Impossibile aprire il file");
            e.printStackTrace();
        }
    }
    
    public void memorizzaSpesaNonSalvata(double spesa) {
        try {
            oout.writeDouble(spesa);
            System.out.println("CacheSpesaNonSalvata.memorizzaSpesaNonSalvata()" + spesa);
        } catch (IOException ex) {
            System.err.println("Impossibile conservare la spesa!");
            ex.printStackTrace();
        }
    }
    
    public double prelevaSpesaNonSalvata() {
        double c = 0;
        try {
            System.out.println("CacheSpesaNonSalvata.prelevaSpesaNonSalvata()");            
            c = (double)oin.readDouble();
        } catch (IOException ex) {
            System.err.println("Impossibile prelevare!");
            ex.printStackTrace();
        }
        return c;
    }
    
}
