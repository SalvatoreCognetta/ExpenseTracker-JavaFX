import java.sql.*;
import java.util.*;

/**
 * DataBaseSpese: classe che realizza il back-end e tutte le operazioni da effettuare sulla base di dati.
 */
public class DataBaseSpese {

    private static Connection connessioneADatabase;
    private static PreparedStatement statementSpeseInserite;
    private static PreparedStatement statementSpesePerCategoria;
    private static PreparedStatement statementGetCategorie;
    private static PreparedStatement statementAggiungiSpesa;
    private static String url;
    private static String usernameDatabase;
    private static String passwordDatabase;

    
    public DataBaseSpese (String indirizzoIP, String porta, String nomeDB) {
        url = "jdbc:mysql://"+indirizzoIP+":"+porta+"/"+nomeDB;
        try {
            connessioneADatabase = DriverManager.getConnection(url, "root", "");
            statementSpeseInserite = connessioneADatabase.prepareStatement("SELECT * FROM spesa");
            statementSpesePerCategoria = connessioneADatabase.prepareStatement("DELETE FROM spesa WHERE idSpesa = ?");
            statementGetCategorie = connessioneADatabase.prepareStatement("SELECT nome FROM categoria");
            statementAggiungiSpesa = connessioneADatabase.prepareStatement("INSERT INTO spesa VALUES (?,?,?,?,?)");
        } catch(SQLException e) {
            System.err.println(e.getMessage());            
        }
     
    }

    public List<Spesa> ottieniListaSpese() {
        List<Spesa> listaSpese = new ArrayList<>();
        try(ResultSet rs = statementSpeseInserite.executeQuery();) {
            while(rs.next())
                listaSpese.add(new Spesa(rs.getInt("idSpesa"), rs.getDouble("costo"), rs.getString("categoria"), rs.getString("descrizione"), rs.getString("data")));
        } catch(SQLException e ) {
            System.err.println(e.getMessage()); 
        }
        return listaSpese;
    }
    
    public void aggiungiSpesa(double costo, String categoria, String descrizione, String data) {
        try{
            statementAggiungiSpesa.setInt(1, 0);
            statementAggiungiSpesa.setDouble(2, costo);
            statementAggiungiSpesa.setString(3, categoria);
            statementAggiungiSpesa.setString(4, descrizione);
            statementAggiungiSpesa.setString(5, data); 

            statementAggiungiSpesa.executeUpdate();
            System.out.println("Spesa salvata.");

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    public void eliminaSpesa(int idSpesa) {
        try{
            statementSpesePerCategoria.setInt(1, idSpesa);
            statementSpesePerCategoria.executeUpdate();
            System.out.println("Spesa eliminata.");
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public List<String> ottieniCategorie() {
        List<String> listaCategorie = new ArrayList<>();
        try(ResultSet rs = statementGetCategorie.executeQuery();) {
            while(rs.next())
                listaCategorie.add(rs.getString("nome"));
        } catch(SQLException e ) {
            System.err.println(e.getMessage()); 
        }
        return listaCategorie;
    }
    
}