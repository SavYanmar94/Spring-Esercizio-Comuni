package it.corso.dto;

public class ComuniDto {

	private int id;
	private String nome;
	private String codiceCatastale;
	private String provincia;
	private String cap;
	private String prefisso;
	private String mail;
	private String pec;
	private String telefono;
	private String fax;
	private ComuniCoordinateDto coordinata;
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
	public ComuniCoordinateDto getCoordinata() {
		return coordinata;
	}
	public void setCoordinata(ComuniCoordinateDto coordinata) {
		this.coordinata = coordinata;
	}
	
	
}
