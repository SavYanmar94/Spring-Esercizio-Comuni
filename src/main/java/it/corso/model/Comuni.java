package it.corso.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

//Indica che questa classe è una entità JPA
@Entity
//Specifica il nome della tabella nel database a cui questa entità è associata
@Table(name = "comuni")
public class Comuni {

 // Identificatore univoco per l'entità
 @Id
 // Genera automaticamente il valore dell'identificatore in base alla strategia scelta
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 
 // Campo "nome" con validazione tramite espressione regolare
 @Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,255}", message = "Nome non corretto")
 @Column(name = "nome")
 private String nome;
 
 // Campo "codiceCatastale" con validazione tramite espressione regolare
 @Pattern(regexp="[A-Z][0-9]{3}", message = "Codice catastale non corretto")
 @Column(name = "codice_catastale")
 private String codiceCatastale;
 
 // Campo "provincia" con validazione tramite espressione regolare
 @Pattern(regexp = "[a-zA-Z]{2}", message = "Provincia non valida")
 @Column(name = "provincia")
 private String provincia;
 
 // Campo "cap" con validazione tramite espressione regolare
 @Pattern(regexp = "[0-9]{5}", message = "Cap non valido")
 @Column(name = "cap")
 private String cap;
 
 // Campo "prefisso" con validazione tramite espressione regolare
 @Pattern(regexp = "[0-9]{4}", message = "Prefisso non valido")
 @Column(name = "prefisso")
 private String prefisso;
 
 // Campo "mail" con validazione tramite espressione regolare
 @Pattern(regexp = "[A-z0-9\\.\\+_-]+@[A-z0-9\\._-]+\\.[A-z]{2,6}", message = "Mail non valida")
 @Column(name = "mail")
 private String mail;
 
 // Campo "pec" con validazione tramite espressione regolare
 @Pattern(regexp = "[A-z0-9\\.\\+_-]+@[A-z0-9\\._-]+\\.[A-z]{2,6}", message = "Mail non valida")
 @Column(name = "pec")
 private String pec;
 
 // Campo "telefono" con validazione tramite espressione regolare
 @Pattern(regexp = "[0-9\\s+.-]{1,20}", message = "Telefono non valido")
 @Column(name = "telefono")
 private String telefono;
 
 // Campo "fax" con validazione tramite espressione regolare
 @Pattern(regexp = "[0-9\\s+.-]{1,20}", message = "Fax non valido")
 @Column(name = "fax")
 private String fax;
 
 // Campo "coordinata" associato a un'altra entità tramite relazione uno a uno
 @Valid
 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "id_coordinata", referencedColumnName = "id")
 private Coordinate coordinata;

 // Metodi getter e setter per gli attributi
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceCatastale() {
		return codiceCatastale;
	}

	public void setCodiceCatastale(String codiceCatastale) {
		this.codiceCatastale = codiceCatastale;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getPrefisso() {
		return prefisso;
	}

	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Coordinate getCoordinata() {
		return coordinata;
	}

	public void setCoordinata(Coordinate coordinata) {
		this.coordinata = coordinata;
	}
	
	

}
