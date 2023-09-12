package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.ComuniDao;
import it.corso.dto.ComuniDto;

import it.corso.helper.ResponseManager;
import it.corso.model.Comuni;
import it.corso.model.Coordinate;

@Service
//Questa classe è annotata come un servizio Spring, il che significa che è gestita dal container Spring.
public class ComuniServiceImpl implements ComuniService {
	
	@Autowired
	// Con @Autowired, Spring inietta automaticamente un'istanza di ComuniDao
	// in questa classe quando viene creata dall'applicazione.
	private ComuniDao comuneDao;
	
	@Autowired
	private ResponseManager responseManager;
	
	private ModelMapper mapper = new ModelMapper();

	@Override
    public ObjectNode comuneRegistration(Comuni comune) {
        // Salva un oggetto Comuni nel database.
        comuneDao.save(comune);
        return responseManager.getResponse(201, "Comune Registrato");
    }

    @Override
    public ObjectNode comuneDataUpdate(Comuni comune) {
        // Cerca un Comuni esistente per il codice catastale fornito e aggiorna i suoi dati con quelli del nuovo comune.
        Comuni existing = comuneDao.findByCodiceCatastale(comune.getCodiceCatastale());
        if (existing == null)
            // Se il comune non esiste, restituisci una risposta con codice 404 (Non trovato).
            return responseManager.getResponse(404, "Comune non trovato");
        overwriteComuniData(existing, comune);
        // Salva il comune aggiornato nel database.
        comuneDao.save(existing);
        // Restituisci una risposta con codice 202 (Accettato) per indicare che l'aggiornamento è avvenuto con successo.
        return responseManager.getResponse(202, "Comune Aggiornato con successo");
    }

    private void overwriteComuniData(Comuni existing, Comuni comune) {
        // Sovrascrive i dati del comune esistente con quelli del nuovo comune.
        existing.setNome(comune.getNome());
        existing.setProvincia(comune.getProvincia());
        existing.setCap(comune.getCap());
        existing.setPrefisso(comune.getPrefisso());
        existing.setMail(comune.getMail());
        existing.setPec(comune.getPec());
        existing.setTelefono(comune.getTelefono());
        existing.setFax(comune.getFax());
        Coordinate coordinata = existing.getCoordinata();
        coordinata.setLat(comune.getCoordinata().getLat());
        coordinata.setLng(comune.getCoordinata().getLng());
        existing.setCoordinata(coordinata);
    }

    @Override
    public ObjectNode comuneRemoval(String codiceCatastale) {
        // Cerca un comune per il codice catastale fornito e lo rimuove dal database.
        Comuni comune = comuneDao.findByCodiceCatastale(codiceCatastale);
        if (comune == null)
            // Se il comune non esiste, restituisci una risposta con codice 404 (Non trovato).
            return responseManager.getResponse(404, "Comune non trovato");
        comuneDao.delete(comune);
        // Restituisci una risposta con codice 202 (Accettato) per indicare che il comune è stato rimosso con successo.
        return responseManager.getResponse(202, "Comune Rimosso con successo");
    }

    @Override
    public List<ComuniDto> getComuni() {
        // Ottiene una lista di tutti i comuni nel database e li mappa in oggetti ComuniDto.
        List<Comuni> comuni = (List<Comuni>) comuneDao.findAll();
        List<ComuniDto> comuniDto = new ArrayList<>();
        comuni.forEach(c -> comuniDto.add(mapper.map(c, ComuniDto.class)));
        return comuniDto;
    }

    @Override
    public ComuniDto getComuneByCodiceCatastale(String codiceCatastale) {
        // Cerca un comune per il codice catastale fornito e lo mappa in un oggetto ComuniDto.
        Comuni comune = comuneDao.findByCodiceCatastale(codiceCatastale);
        ComuniDto comuneDto = mapper.map(comune, ComuniDto.class);
        return comuneDto;
    }
}