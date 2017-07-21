import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import javafx.scene.chart.PieChart;

/**
 * DataBaseSpese: classe che realizza il back-end e tutte le operazioni da effettuare sulla base di dati.
 */
public class DataBaseSpese {

    private static Connection connessioneADatabase;
    private static PreparedStatement statementGetSpeseInserite;
    private static PreparedStatement statementGetCategorie;
    private static PreparedStatement statementGetStorico;
    private static PreparedStatement statementAggiungiSpesa;
    private static PreparedStatement statementEliminaSpesa;
    private static String url;
    private static String usernameDatabase;
    private static String passwordDatabase;

    
    public DataBaseSpese (String indirizzoIP, String porta, String nomeDB) {
        url = "jdbc:mysql://"+indirizzoIP+":"+porta+"/"+nomeDB;
        try {
            connessioneADatabase = DriverManager.getConnection(url, "root", "");
            statementGetSpeseInserite = connessioneADatabase.prepareStatement("SELECT * FROM spesa");
            statementGetCategorie = connessioneADatabase.prepareStatement("SELECT nome FROM categoria");
            statementGetStorico = connessioneADatabase.prepareStatement("SELECT SUM(costo) as costo, categoria FROM spesa WHERE data>? AND data<? GROUP BY categoria");     
            statementAggiungiSpesa = connessioneADatabase.prepareStatement("INSERT INTO spesa VALUES (?,?,?,?,?)");
            statementEliminaSpesa = connessioneADatabase.prepareStatement("DELETE FROM spesa WHERE idSpesa = ?");
        } catch(SQLException e) {
            System.err.println(e.getMessage());            
        }
     
    }

    public List<Spesa> ottieniListaSpese() {
        List<Spesa> listaSpese = new ArrayList<>();
        try(ResultSet rs = statementGetSpeseInserite.executeQuery();) {
            while(rs.next())
                listaSpese.add(new Spesa(rs.getInt("idSpesa"), rs.getDouble("costo"), rs.getString("categoria"), rs.getString("descrizione"), rs.getDate("data").toString()));
        } catch(SQLException e ) {
            System.err.println(e.getMessage()); 
        }
        return listaSpese;
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
    
    public List<PieChart.Data> ottieniStoricoSpese(LocalDate dataInizio, LocalDate dataFine) {
        List<PieChart.Data> listaStorico = new ArrayList<>();
        try {
            statementGetStorico.setDate(1, java.sql.Date.valueOf(dataInizio));
            statementGetStorico.setDate(2, java.sql.Date.valueOf(dataFine));
            ResultSet rs = statementGetStorico.executeQuery();
            
            //adding data on piechart data

//                data.add(new PieChart.Data(rs.getString(2),rs.getDouble(1)));

            while(rs.next())
                listaStorico.add(new PieChart.Data(rs.getString("categoria"), rs.getDouble("costo")));
            

        } catch(SQLException e) {
            
        }
        return listaStorico;
    }
    
    public void aggiungiSpesa(double costo, String categoria, String descrizione, LocalDate data) {
        try{
            statementAggiungiSpesa.setInt(1, 0);
            statementAggiungiSpesa.setDouble(2, costo);
            statementAggiungiSpesa.setString(3, categoria);
            statementAggiungiSpesa.setString(4, descrizione);
            statementAggiungiSpesa.setDate(5, java.sql.Date.valueOf(data)); 

            statementAggiungiSpesa.executeUpdate();
            System.out.println("Spesa salvata.");

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    public void eliminaSpesa(int idSpesa) {
        try{
            statementEliminaSpesa.setInt(1, idSpesa);
            statementEliminaSpesa.executeUpdate();
            System.out.println("Spesa eliminata.");
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    
    
    
}