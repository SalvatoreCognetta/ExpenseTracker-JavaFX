# Registro attività (Tot 38.71h)
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
Inserita una nuova classe bean, StoricoSpese, utilizzata come parametri del diagramma a torta. Inserito metodo nella classe DatabaseSpese per la restituzione di una lista di StoricoSpese. Inseriti metodi nella classe TabellaUltimeSpese per l'aggiornamento ed il caricamento all'avvio delle spese. Creata la classe RegistroPerCategoria. Aggiunta classe ParametriConfigurazione che contiene i parametri di configurazione locale in XML. Inserita classe GestoreParametriConfigurazioneXML con i metodi.

## 11 Luglio 2017 (3.15)
Inserita la classe ConsultazioneSpese.Modificate le classi NuovaSpesa, TabellaUltimeSpese e RegistroPerCategoria inserendo gli attributi HBox e VBox; inseriti anche i metodi getVbox.Testato codice delle componenti HBox, VBox e TableView, per capire se la classe TabellaUltimeSpese dovesse essere scomposta in due. Inserito l'attributo TableView<Spesa>.Visualizzato il codice riguardante la ComboBox e il PieChart.Inserita classe CacheSpesaNonSalvata. Inserite le classi MessaggioDiLog e ServerDiLog.

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

## 20 Luglio 2017 (1.63)
Nel metodo salvaSpesa della classe NuovaSpesa invece di inviare la data della spesa sotto forma di stringa la invio come LocalDate; modificato di conseguenza il metodo aggiungiSpesa della classe DataBaseSpese, ora ha come parametro un LocalDate che viene convertito java.sql.Date.valueOf(data); modificata quindi la base di dati, ora le date non sono VARCHAR ma DATE, in modo da poter effettuare delle operazioni sulle date (come le spese effettuate in un certo periodo, utili per la classe RegistroPerCategoria). La classe bean spesa non viene modificata, poichè la data è comunque convertita a String.

## 21 Luglio 2017 (3.54h)
Nella classe RegistroPerCategoria aggiunto il metodo aggiornaGrafico(), che viene lanciato all'avvio e ogni volta che si preme il button "Aggiorna". Inserito, nel metodo, il caso in cui non fosse presente nessun record (d.add(new PieChart.Data("Nessun valore", 1));). Creata la classe CacheSpesaNonSalvata ed i metodi prelevaSpesaNonSalvata e memorizzaSpesaNonSalvata. Modificata il costruttore della classe NuovaSpesa in modo da inizializzare i campi presenti con i dati salvati nel file binario. 

## 22 Luglio 2017 (3.00h)
Nella classe NuovaSpesa aggiunta anche l'inizializzazione del datePicker tramite cache locale. Il datePicker ora invece che avere un valore di defualt ha un promptText (era un errore perchè in chiusura veniva salvato sempre la data dell'ultima apertura anche senza nessun inserimento). Creata le classi ParametriConfigurazione e GestoreParametriConfigurazioneXML, che valida e restituisce i parametri di configurazione. Creati il costruttore e i metodi che validano il file e settano i parametri. 

## 22 Luglio 2017 (1.53h)
Aggiunti metodi get nella classe ParametriConfigurazione. Implementato il gestoreParametriConfigurazione nella costruttore della classe DatabaseSpese (viene stabilita la connessione al db tramite i parametri di config). Creato il costruttore della classe LogXMLAttivita. Create anche la classe MessaggioDiLog e l'enumerato TipoLog, usati dal metodo inviaMessaggioLog. Creati i metodi inviaMessaggioLog e serilizzaXML della classe LogXML per l'invio al server del messaggio di log serializzato.

## 23 Luglio 2017 (1.66h)
Modificato il metodo annullaInserimento della classe nuovaSpesa, ora si ripuliscono anche i campi categoria e data. Aggiunti tutti i casi in cui l'applicativo deve inviare un messaggio di log (avvio, click sulla gui, termine). Modificato il metodo salvaSpesa di NuovaSpesa, se non ci sono i parametri inseriti la spesa non viene salvata, se manca la data in automatico la spesa è riferita a now(). Impostata la posizione dei button,label e datepicker. Aggiunto il bordo e lo spacing all'applicativo.

## 24 Luglio 2017 (3.03h)
Settato il bordo, spacing, colore e font per le classi NuovaSpesa,TabellaUltimeSpese,RegistroPerCategoria. Settato il numero di righe visibili nella tabella modificando la query(LIMIT numRow); impostata la dimensione max e min(in caso non ci siano elementi) della tabella. Le righe della tabella ora appaiono in apertura ordinate secondo la data.Tolta la possibilità di ridimensionare lo stage.Creato il file di validazione xsd per il file di configurazione. Testato l'applicativo sui casi stabiliti