Traccia 

Utilizzando lo schema di database MySql fornito, realizza, mediante progetto Spring Boot,
un web service che fornisca diversi endpoint per implementare le seguenti funzionalità:

I. Restituzione, in formato JSON, dell'intero elenco Comuni registrato nel database
con informazioni complete per ciascun comune

II. Restituzione, in formato JSON, delle informazioni complete del Comune
desiderato, opportunamente identificato mediante Codice Catastale

III. Registrazione di un nuovo Comune nel database

IV. Modifica dei dati di un Comune registrato nel database, opportunamente
identificato mediante Codice Catastale

V. Cancellazione di un Comune registrato nel database, opportunamente identificato
mediante Codice Catastale

Il Web Service deve essere strutturato in modo tale da prevenire la generazione di
potenziali eccezioni con particolare riferimento a:


• tentativo di modifica dei dati di un Comune non registrato nel database
• tentativo di cancellazione di un Comune non registrato nel database
Non deve inoltre risultare possibile la duplicazione dei Codici Catastali

Esercizio Svolto in gruppo
