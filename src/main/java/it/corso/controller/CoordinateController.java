package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corso.dto.CoordinateDto;
import it.corso.service.CoordinateService;

@RestController
@RequestMapping("/townships/coordinate")
// L'annotazione @RestController indica che questa classe è un controller REST,
// cioè un componente che gestisce le richieste HTTP e restituisce risposte JSON.
// @RequestMapping specifica il prefisso dell'URL per tutti i metodi in questa classe.
public class CoordinateController {
	
	@Autowired
	// Con @Autowired, Spring inietta automaticamente un'istanza di CoordinateService
	// in questa classe quando viene creata dall'applicazione.
	private CoordinateService coordinataService;
	
	// endpoint #1: elenco di tutte le coordinate  localhost:8080/townships/coordinate/get
	@GetMapping("/get")
	// L'annotazione @GetMapping specifica che questo metodo gestisce le richieste HTTP GET
	// rivolte all'URL /townships/coordinate/get.
	public ResponseEntity<List<CoordinateDto>> getCoordinate() {
		// Richiama il servizio CoordinateService per ottenere una lista di CoordinateDto.
		List<CoordinateDto> response = coordinataService.getCoordinate();
		
		// Crea una risposta HTTP ResponseEntity che contiene la lista di CoordinateDto
		// e lo stato HTTP OK (200).
		return new ResponseEntity<List<CoordinateDto>>(response, HttpStatus.OK);
	}
}
