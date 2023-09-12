package it.corso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dto.ComuniDto;
import it.corso.model.Comuni;
import it.corso.service.ComuniService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("townships/comuni")
//L'annotazione @RestController indica che questa classe è un controller REST
//per la gestione dei comuni. @RequestMapping specifica il prefisso dell'URL per tutti i metodi in questa classe.
public class ComuniController {

	@Autowired
	// Con @Autowired, Spring inietta automaticamente un'istanza di ComuniService
	// in questa classe quando viene creata dall'applicazione.
	private ComuniService comuneService;
	
	//endpoint#1:registrazione nuovo comune  localhost:8080/townships/comuni/reg
	@PostMapping("/reg")
	// L'annotazione @PostMapping specifica che questo metodo gestisce le richieste HTTP POST
	// rivolte all'URL /townships/comuni/reg. Accetta un oggetto Comuni come corpo della richiesta.
	public ResponseEntity<ObjectNode> comuniRegistration(@RequestBody Comuni comune){
		// Richiama il servizio ComuniService per registrare un nuovo comune.
		ObjectNode response = comuneService.comuneRegistration(comune);
		// Crea una risposta HTTP ResponseEntity che contiene l'oggetto di risposta e lo stato HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response,HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	//endpoint#2:modifica dati comune  localhost:8080/townships/comuni/update
	@PutMapping("/update")
	// L'annotazione @PutMapping specifica che questo metodo gestisce le richieste HTTP PUT
	// rivolte all'URL /townships/comuni/update. Accetta un oggetto Comuni come corpo della richiesta.
	public ResponseEntity<ObjectNode> comuneDataUpdate(@Valid @RequestBody Comuni comune){
		// Richiama il servizio ComuniService per aggiornare i dati del comune.
		ObjectNode response = comuneService.comuneDataUpdate(comune);
		// Crea una risposta HTTP ResponseEntity che contiene l'oggetto di risposta e lo stato HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response,HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	//endpoint#3:cancellazione comune  localhost:8080/townships/comuni/delete/{CodiceCatastale}
	@DeleteMapping("/delete/{CodiceCatastale}")
	// L'annotazione @DeleteMapping specifica che questo metodo gestisce le richieste HTTP DELETE
	// rivolte all'URL /townships/comuni/delete/{CodiceCatastale}. Il parametro CodiceCatastale è estratto dall'URL.
	public ResponseEntity<ObjectNode> comuneRemoval(@PathVariable("CodiceCatastale")String CodiceCatastale){
		// Richiama il servizio ComuniService per rimuovere un comune.
		ObjectNode response = comuneService.comuneRemoval(CodiceCatastale);
		// Crea una risposta HTTP ResponseEntity che contiene l'oggetto di risposta e lo stato HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response,HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	//endpoint#4 : elenco comuni localhost:8080/townships/comuni/get
	@GetMapping("/get")
	// L'annotazione @GetMapping specifica che questo metodo gestisce le richieste HTTP GET
	// rivolte all'URL /townships/comuni/get.
	public ResponseEntity<List<ComuniDto>> getComuni(){
		// Richiama il servizio ComuniService per ottenere un elenco di comuni.
		List<ComuniDto> response = comuneService.getComuni();
		// Crea una risposta HTTP ResponseEntity che contiene l'elenco e lo stato HTTP OK (200).
		return new ResponseEntity<List<ComuniDto>>(response, HttpStatus.OK);
	}
	
	//endpoint#5 : ricerca comune per codice catastale localhost:8080/townships/comuni/get/{codice_catastale}
	@GetMapping("/get/{CodiceCatastale}")
	// L'annotazione @GetMapping specifica che questo metodo gestisce le richieste HTTP GET
	// rivolte all'URL /townships/comuni/get/{CodiceCatastale}. Il parametro CodiceCatastale è estratto dall'URL.
	public ResponseEntity<ComuniDto> getComunibyCodiceCatastale(@PathVariable("CodiceCatastale")String CodiceCatastale)
	{
		// Richiama il servizio ComuniService per ottenere un comune specifico in base al codice catastale.
		ComuniDto response = comuneService.getComuneByCodiceCatastale(CodiceCatastale);
		// Crea una risposta HTTP ResponseEntity che contiene l'oggetto di risposta e lo stato HTTP OK (200).
		return new ResponseEntity<ComuniDto>(response, HttpStatus.OK);
	}
	
	// Gestione eccezione validazione dati
	@ExceptionHandler(BindException.class)
	// L'annotazione @ExceptionHandler specifica che questo metodo gestirà eccezioni di tipo BindException.
	public ResponseEntity<Map<String, String>> handleValidationException(BindException e)
	{
		Map<String, String> errors = new HashMap<>();
		// Ottiene gli errori di validazione dal risultato del binding e li inserisce in una mappa.
		e.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		// Restituisce una risposta HTTP ResponseEntity con gli errori e uno stato HTTP BAD_REQUEST (400).
		return ResponseEntity.badRequest().body(errors);
	}
}
