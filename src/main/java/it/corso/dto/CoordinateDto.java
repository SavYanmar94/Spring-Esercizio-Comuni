package it.corso.dto;

public class CoordinateDto {

	private int id;
	private double lat;
	private double lng;
	private CoordinateComuniDto comune;
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
	public CoordinateComuniDto getComune() {
		return comune;
	}
	public void setComune(CoordinateComuniDto comune) {
		this.comune = comune;
	}
	
	
}
