package it.corso.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dto.ComuniDto;
import it.corso.model.Comuni;

//Questa è un'interfaccia che definisce i metodi che una classe di servizio per i comuni deve implementare.
public interface ComuniService {

 // Metodo per registrare un comune
 ObjectNode comuneRegistration(Comuni comune);

 // Metodo per aggiornare i dati di un comune
 ObjectNode comuneDataUpdate(Comuni comune);

 // Metodo per rimuovere un comune tramite il suo codice catastale
 ObjectNode comuneRemoval(String codiceCatastale);

 // Metodo per ottenere una lista di comuni
 List<ComuniDto> getComuni();

 // Metodo per ottenere i dati di un comune tramite il suo codice catastale
 ComuniDto getComuneByCodiceCatastale(String codiceCatastale);
}