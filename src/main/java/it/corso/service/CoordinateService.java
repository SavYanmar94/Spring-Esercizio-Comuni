package it.corso.service;

import java.util.List;

import it.corso.dto.CoordinateDto;


//Questa è un'interfaccia che definisce il metodo per ottenere una lista di coordinate.
public interface CoordinateService {

 // Metodo per ottenere una lista di coordinate
 List<CoordinateDto> getCoordinate();
}