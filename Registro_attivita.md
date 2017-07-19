# Registro attività (Tot 24.33h)
## 2 Aprile 2017 (1.08h)
Creato un primo schizzo dell'applicativo tramite tool online (https://creately.com/), inserendo: text-box per l'immissione dei vari campi, una tabella che mostra gli ultimi record inseriti e un diagramma a ciambella che mostra le spese effettuate mensilmente raggruppate per categoria. Abbozzato il documento di analisi che illustra lo scopo e gli scenari tipici dell'interfaccia.

## 9 Maggio 2017 (2.12h)
Completato lo schizzo dell'interfaccia, inserendo una nuova tabella che mostra in maniera più dettagliata i record del diagramma a torta. Aggiunto un nuovo button Annulla, che svuota tutti i campi inseriti dall'utente.  Sottolineati ed descritti i termini utilizzati nell'applicativo.Completata la vista dinamica, illustrando come da specifiche uno scenario dei casi d'uso dell'applicativo.

## 19 Maggio 2017 (1.75h)
Inserito un ulteriore button "eliminaSpesa" nella tabella "ultimeSpese" del mockup in modo da rendere possibile l'eliminazione di una spesa registrata erroneamente. Quando questo button viene premuto si elimina il record nella tabella e si aggiornano le due tabelle ed il diagramma presente nell'applicativo. Modificata di conseguenza la vista dinamica. Concluse le specifiche delle altre parti Java di I/O, descrivendo anche la struttura della tabelle della base di dati da utilizzare.

## 24 Maggio 2017 (0.59h)
Eliminata la Tabella "spesaPerCategoria" (il diagramma ha lo stesso scopo della tabella). Inseriti due campi data di fianco il diagramma in modo da poter selezionare un periodo di riferimento per la creazione del diagramma stesso. Eliminati i "eliminaSpesa" dalla tabella "ultimeSpese" e sostituito con un button in fondo alla tabella che elimina i record selezionati. Eliminata la Struttura delle Tabelle nella vista dinamica. Inserito un nuovo evento, invio del log alla selezione di una riga.

## 24 Maggio 2017 (0.68h)
Eliminati i termini camelCase dal Documento di Analisi e sostituiti con italiano per una maggiore leggibilità. Modificata la vista dinamica scomponendo due casi d'uso diversi (inserimento ed eliminazione record). Inserito un button Aggiorna che, se premuto, aggiorna il diagramma a torta. Inserito il caso d'uso riferito al button Aggiorna. Eliminata la spiegazione di cosa fa il database nella vista dinamica.

## 03 Giugno 2017 - 7 luglio 2017 (1.24)
Creazione della documentazione relativa alla prima fase di analisi. Ripasso sulla costruzione dei diagrammi UML (https://tinyurl.com/UMLprg). Creato primo diagramma UML(https://creately.com/), inserite le classi: Spesa (classe bean), Categoria (enumerato che contiene le varie categorie della spesa), GestoreSpesa (gestisce le spese inserite dall'utente, quindi ha metodi annullaInserimento e salvaSpesa).

## 09 Luglio 2017 (0.56)
Rinominata la classe GestoreSpesa in  NuovaSpesa. Creazione della classe TabellaUltimeSpese, che si riferisce alla tabella che contiene tutte le ultime spese effettuate e che utilizza la classe bean Spesa. Creata la classe DataBaseSpese, che ha lo scopo di estrarre dalla base di dati le spese salvate, e di inserire ed eliminare nello stesso una spesa ogni volta che viene premuto il tasto "salva" nella classe NuovaSpesa o il button "elimina" nella Tabella.

## 10 Luglio 2017 (2.47)
Inserita una nuova classe bean, StoricoSpese, utilizzata come parametri del diagramma a torta. Inserito metodo nella classe DatabaseSpese per la restituzione di una lista di StoricoSpese, utilizzata dal diagramma. Inseriti metodi nella classe TabellaUltimeSpese per l'aggiornamento ed il caricamento all'avvio delle spese. Creata la classe RegistroPerCategoria che raggruppa in un grafico, aggiornato con il metodo aggiornaGrafico, le spese per categoria.
Aggiunta classe ParametriConfigurazione che contiene i parametri di configurazione locale in XML, con relativi metodi set e get. Inserita classe GestoreParametriConfigurazioneXML che legge e valida il file di configurazione e restituisce il parametri.

## 11 Luglio 2017 (3.15)
Inserita la classe ConsultazioneSpese, classe principale dell'applicativo. Modificate le 3 classi NuovaSpesa, TabellaUltimeSpese e RegistroPerCategoria inserendo tra gli attributi degli HBox e VBox. Inseriti inoltre in queste ultime metodi che ritornano i rispettivi VBox principali da aggiungere nella scena. Testati frammenti di codice delle componenti HBox, VBox e TableView, per capire se la classe TabellaUltimeSpese dovesse essere scomposta in due. Inserito l'attributo TableView<Spesa>.
Dopo aver visualizzato meglio il codice riguardante la ComboBox, della classe NuovaSpesa, e quello riguardante il PieChart ho aggiunto gli attributi. Inserita classe CacheSpesaNonSalvata che in chiusura memorizza su file binario i parametri inseriti e li carica all'avvio dell'applicativo. Inserite le classi MessaggioDiLog e ServerDiLog, per iviare ad un file di log remoto i messaggi di log. 

## 13 Luglio 2017 (1.37)
Inserite le classi da importare e modificato alcune dipende d'uso tra le classi del diagramma. Modificati i parametri dei costruttori delle classi NuovaSpesa e TabellaUltimeSpese. Ridefinita la classe CacheSpesaNonSalvata, che salva su file binario i parametri inseriti nell'applicativo. Ridisposte la classi nel diagramma per una maggiore visibilità e facilità di lettura.

## 14 Luglio 2017 (1.15)
Aggiunto nel diagramma l'implement dell'interfaccia Serializable da parte di CacheSpesaNonSalvata e ServerDiLog. Aggiunto come attributo la classe CacheSpesaNonSalvata nella classe principale ConsultazioneSpese. Modificato il nome della classe ServerDiLog con LogXMLAttivita. Creato il documento di progetto, in cui ho dettagliato le responsabilità di tutte le classi inserite nell'architettura. Aggiornata quindi la documentazione, aggiungendo la parte relativa alla progettazione.

## 18 Luglio 2017 (2.43)
Ultimata la prima iterazione del diagramma UML in seguito alla correzzione di alcuni package da importare nelle classi TabellaUltimeSpese, RegistroPerCategoria e LogXMLAttivita. Aggiornato, di conseguenza, il documento di progetto e la documentazione. Provati frammenti di codice per il datePicker(https://tinyurl.com/y89jdpyk, https://tinyurl.com/yadd5g42), comboBox(https://tinyurl.com/ycbadxls) per capire l'implementazione nell'applicativo dei componenti non studiati a lezione. 

## 19 Luglio 2017 (2.68)
Passato alla fase di sviluppo, sviluppando le classi per il front-end Spesa, StoricoSpese, TabellaUltimeSpese, ConsultazioneSpese e per il back-end DataBaseSpese. Visto il codice per ottenere una riga selezionata da una TableView ed effettuate delle modifiche al diagramma UML: modificato il valore di ritorno del metodo getData, nella classe Spesa, da Data a String; aggiunto all'interno della classe DataBaseSpese un ulteriore attributo, il PreparedStatement per le spese raggruppate per categoria
## 19 Luglio 2017 (3.06)
Eliminato l'attributo "spesa" dal metodo eliminaSpesa, poichè la spesa selezionata viene selezionata dentro il metodo stesso(table.getSelectionModel().getSelectedItem();). Aggiunto i parametro IDSpesa, ed il relativo metodo get, nella classe Spesa per le operazioni di eliminazione nel db. Nella classe DataBaseSpese eliminati gli attributi indirizzoIP e portaDatabase, inserito invece come attributo la stringa "url", che contiene del db a cui connettersi.

Creata la base di dati RegistroSpese che contiene le tabelle spesa e categoria. Aggiunta la classe front-end NuovaSpesa. Utilizzato un placeholder per i textfield (https://tinyurl.com/prmptext). Creati tutti i metodi della classe NuovaSpesa. Aggiunto il metodo ottieniCategorie nella classe DabaseSpese, che restituisce le categorie da visualizzare nella combobox. Eliminato il parametro List<Spesa> dal metodo caricaSpese, viene calcolata direttamente nella classe. 