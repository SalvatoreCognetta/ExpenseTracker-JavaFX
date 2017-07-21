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