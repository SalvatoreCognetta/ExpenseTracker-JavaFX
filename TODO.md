1. Modificare il return statement del metodo getData, nella classe Spesa, da Data a String. OK
2. Eliminare java.util dall'import della classe Spesa. OK
3. Aggiungere parametri nel costruttore della classe StoricoSpesa. OK
4. Aggiungere all'interno della classe DataBaseSpese un ulteriore attributo: - statementSpesePerCategoria : PreparedStatement. OK
5. dal metodo caricaSpese nella classe TabellaUltimeSpese. Rendere void lo stesso metodo ed il metodo eliminaSpesa. OK
6. Eliminare l'attributo Spesa spesa dal metodo eliminaSpesa, la spesa selezionata viene trovata dentro il metodo stesso. OK
7. Aggiungere parametro IDSpesa nella classe Spesa (autoincrementante). Inserire inoltre un parametro static per la determinazione dell'ID. OK
8. Aggiungere parametro String url nella classe DataBaseSpese. Inserire inoltre anche il parametro nomeDatabase nei parametri di configurazione! OK
9. Eliminare l'attributo indirizzoIPDatabase e portaDatabase dalla classe DataBaseSpese, basta l'attributo url. OK

10. Modificare l'attributo "spesa" con idSpesa, nel metodo eliminaSpesa della classe DataBaseSpese. OK
11. Aggiungere il metodo ottieniCategorie nella classe DabaseSpese, che restituisce le categorie da visualizzare nella combobox. OK
12. Cambiare da public a private i metodi annulla e salva spesa di NuovaSpesa. OK
13. Eliminare l'attributo List<Spesa> dal metodo caricaSpese, viene calcolata direttamente nella classe. OK

14. Modificare l'attributo "spesa" del metodo aggiungiSpesa nella classe DataBaseSpese con gli attributi double costo, String categoria, String descrizione, String data. OK
15. Aggiunger import a NuovaSpesa: import java.time.format.*; OK



16. Modificare il parametro String data in LocalDate data nel metodo aggiungiSpesa della classe DataBaseSpese.
17. Modificare il parametro Data dataInizio e fine in LocalDate data nel metodo ottieniSpesePerData della classe DataBaseSpese.
18. Modificare gli attributi della classe DataBaseSpese:
    private static Connection connessioneADatabase;
    private static PreparedStatement statementGetSpeseInserite;
    private static PreparedStatement statementGetCategorie;
    private static PreparedStatement statementGetStorico;
    private static PreparedStatement statementAggiungiSpesa;
    private static PreparedStatement statementEliminaSpesa;
    private static String url;
    private static String usernameDatabase;
    private static String passwordDatabase;
19. Modificare il nome del metodo ottieniSpesePerData con ottieniStoricoSpese in DBSPESE

20. Aggiungere le label "Data Inizio" e "Data Fine" nella classe registro per categoria.
21. In DataBaseSpese, nel metodo ottieniSpesePerData invece restituire List<StoricoSpese> restituire List<PieChart.Data>. 
22. Eliminare la classe StoricoSpese, inutile.
23. Nella classe CacheSpesa non salvata bisogna passare nel costruttore il parametro File file. Inoltre aggiungere tra gli attributi della classe ObjectInputStream e ObjectOutputStream.
24. La classe memorizzaSpesaNonSalvata(...) deve avere come parametro String[] spesa.
25. Aggiungere l'attributo CacheSpesaNonSalvata nella classe NuovaSpesa, per memorizzare e leggere l'ultima spesa inserita.
26. La classe CacheSpesaNonSalvata non va serializzata.
27. Nella classe GestoreParametri importare javax.xml.*; e import javax.xml.parsers.*; import org.xml.sax.*; import javax.xml.validation.*; import org.w3c.dom.*; import javax.xml.transform.stream.*; import javax.xml.transform.dom.*; import java.nio.file.*;
28. Nei parametriconfigurazione bisogna aggiungere la string nomedb, eliminare String colreBackground
29. La classe ParametriConfigurazione implementa Serializable.
30. Eliminare i metodi set dalla classe ParametriConfigurazione.
31. Nella classe LOGXMLAttivita modificata ObjectOutputStream con DataOutputStream.
32. Modificare la classe MessaggioDiLog, deve contetnere anch l'indirizzo ip del client.
34. Nella classe LogXMLAttivita aggiunger import com.thoughtworks.xstream.*;
35. Aggiungere la classe Server che riceve le righe di log.
36. Modificare gli attributi della classe LogXMLAtt, eliminare il Socket e il DataOutputStream.
37. Modificare tutti i nomi da serverDiLog a socketDilog.
39. Aggiungere il parametro ParametriConfigurazione nella classe NuovaSpesa e a TabellaUltimeSpese.
41. Eliminare l'attributo maxRecord da TabUltimeSpese.
42. In DataBaseSpese, nel costruttore non va passato il GestoreParam ma i Parametri
43. Modificare la classe MessaggioDiLog, aggiungere nome applicazione, indirizzo-ip client, ora corrente.
44. Eliminare la metodo leggiDaFile e il metodo validaFileDiCon ritorna void non boolean, nella classe GestoreParam.

