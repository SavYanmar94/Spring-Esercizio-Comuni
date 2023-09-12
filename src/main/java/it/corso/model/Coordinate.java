package it.corso.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//Indica che questa classe è una entità JPA
@Entity
//Specifica il nome della tabella nel database a cui questa entità è associata
@Table(name = "coordinate")
public class Coordinate {

 // Identificatore univoco per l'entità
 @Id
 // Genera automaticamente il valore dell'identificatore in base alla strategia scelta
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 
 // Campo "lat" per la latitudine
 @Column(name = "lat")
 private double lat;

 // Campo "lng" per la longitudine
 @Column(name = "lng")
 private double lng;
 
 // Campo di associazione tra Coordinate e Comuni tramite relazione uno a uno
 @OneToOne(mappedBy = "coordinata", cascade = CascadeType.ALL)
 private Comuni comune;

 // Metodi getter e setter per gli attributi
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Comuni getComune() {
		return comune;
	}

	public void setComune(Comuni comune) {
		this.comune = comune;
	}
	
	
}
