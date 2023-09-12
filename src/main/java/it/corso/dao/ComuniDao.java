package it.corso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Comuni;



public interface ComuniDao extends CrudRepository<Comuni, Integer>{

	 // Questa è un'interfaccia che estende CrudRepository e definisce operazioni
    // di accesso ai dati per la classe Comuni.

    Comuni findByCodiceCatastale(String codiceCatastale);
    // Questo è un metodo dichiarato nell'interfaccia per recuperare un oggetto Comuni
    // in base al suo codice catastale. Spring Data JPA fornirà automaticamente
    // un'implementazione di questo metodo senza la necessità di scriverlo manualmente.
    // Questo è possibile grazie alla convenzione di denominazione dei metodi di query di Spring Data JPA.
}