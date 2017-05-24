### Struttura tabelle Base di Dati
**Categoria**
idCategoria: INT, AUTO_INCREMENT, PRIMARY KEY,
categoriaSpesa: VARCHAR(45), NOT NULL

La tabella Categoria contiene la lista di categorie di spesa tra cui l'utente può scegliere nella fase di inserimento di un nuovo record.


**Spese**
idSpesa: INT, AUTO_INCREMENT, PRIMARY KEY,
descrizioneSpesa: VARCHAR(45),
costoSpesa: INT, NOT NULL,
dataSpesa: DATE, NOT NULL,
idCategoria: FOREIGN KEY

La tabella Spese contiene le spese inserite dall'utente.
Ogni spesa è caratterizzata da un id numerico, una descrizione testuale, il costo e la data in cui la spesa è stata effettuata.
