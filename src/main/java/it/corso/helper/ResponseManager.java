package it.corso.helper;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

//Indica che questa classe è un componente gestito da Spring, che sarà automaticamente creato e gestito dal contesto dell'applicazione.
@Component
public class ResponseManager
{
    // Un oggetto ObjectMapper per la gestione delle conversioni JSON
    private ObjectMapper mapper;
    
    public ResponseManager()
    {
        // Inizializza l'oggetto ObjectMapper nel costruttore
        mapper = new ObjectMapper();
    }
    
    // Metodo per ottenere una risposta JSON con un codice e un messaggio specificati
    public ObjectNode getResponse(int code, String message)
    {
        // Crea un oggetto ObjectNode per rappresentare la risposta JSON
        ObjectNode response = mapper.createObjectNode();
        
        // Aggiunge il codice e il messaggio alla risposta JSON
        response.put("code", code);
        response.put("message", message);
        
        // Restituisce la risposta JSON
        return response;
    }
}