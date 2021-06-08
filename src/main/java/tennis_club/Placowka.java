package tennis_club;


public class Placowka {

	private int idPlacowki;
	private String nazwaPlacowki;
	private String nrTelefonu;
	private int idAdresu;
	private int idKlubu;
	
	public Placowka() {
		
	}

	public Placowka(int idPlacowki, String nazwaPlacowki, String nrTelefonu, int idAdresu, int idKlubu) {
		super();
		this.idPlacowki = idPlacowki;
		this.nazwaPlacowki = nazwaPlacowki;
		this.nrTelefonu = nrTelefonu;
		this.idAdresu = idAdresu;
		this.idKlubu = idKlubu;
	}
	
	
	public int getIdPlacowki() {
		return idPlacowki;
	}

	public void setIdPlacowki(int idPlacowki) {
		this.idPlacowki = idPlacowki;
	}

	public String getNazwaPlacowki() {
		return nazwaPlacowki;
	}

	public void setNazwaPlacowki(String nazwaPlacowki) {
		this.nazwaPlacowki = nazwaPlacowki;
	}

	public String getNrTelefonu() {
		return nrTelefonu;
	}

	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	public int getIdAdresu() {
		return idAdresu;
	}

	public void setIdAdresu(int idAdresu) {
		this.idAdresu = idAdresu;
	}

	public int getIdKlubu() {
		return idKlubu;
	}

	public void setIdKlubu(int idKlubu) {
		this.idKlubu = idKlubu;
	}
}
