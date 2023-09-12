package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CoordinateDao;
import it.corso.dto.CoordinateDto;
import it.corso.model.Coordinate;
@Service
//L'annotazione @Service indica a Spring che questa classe è un componente
//di servizio e dovrebbe essere gestita dal container Spring.
public class CoordinateServiceImpl implements CoordinateService {

	@Autowired
	// Con @Autowired, Spring inietta automaticamente un'istanza di CoordinateDao
	// in questa classe quando viene creata dall'applicazione.
	private CoordinateDao coordinateDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	// Questo metodo implementa un'operazione per ottenere una lista di CoordinateDto.
	public List<CoordinateDto> getCoordinate() {
		// Recupera tutte le coordinate dal database utilizzando il CoordinateDao.
		List<Coordinate> coordinate = (List<Coordinate>) coordinateDao.findAll();
		
		// Crea una lista di CoordinateDto vuota per immagazzinare i risultati.
		List<CoordinateDto> coordinateDto = new ArrayList<>();
		
		// Itera attraverso le coordinate recuperate e le converte in CoordinateDto
		// utilizzando il ModelMapper, quindi le aggiunge alla lista dei risultati.
		coordinate.forEach(a ->  coordinateDto.add(mapper.map(a, CoordinateDto.class)));
		
		// Restituisce la lista di CoordinateDto.
		return coordinateDto;
	}
}