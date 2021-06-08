package tennis_club;

public class Client {
	
	public int getIdKlienta() {
		return idKlienta;
	}

	public void setIdKlienta(int idKlienta) {
		this.idKlienta = idKlienta;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNrTelefonu() {
		return nrTelefonu;
	}

	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	public String getStatusKlienta() {
		return statusKlienta;
	}

	public void setStatusKlienta(String statusKlienta) {
		this.statusKlienta = statusKlienta;
	}

	public String getNrSzafki() {
		return nrSzafki;
	}

	public void setNrSzafki(String nrSzafki) {
		this.nrSzafki = nrSzafki;
	}

	public int getIdKlubu() {
		return idKlubu;
	}

	public void setIdKlubu(int idKlubu) {
		this.idKlubu = idKlubu;
	}

	private int idKlienta;
	private String imie;
	private String nazwisko;
	private String nrTelefonu;
	private String statusKlienta;
	private String nrSzafki;
	private int idKlubu;
	
	public Client() {
		
	}

	public Client(int idKlienta, String imie, String nazwisko, String nrTelefonu, String statusKlienta, String nrSzafki,
			int idKlubu) {
		super();
		this.idKlienta = idKlienta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrTelefonu = nrTelefonu;
		this.statusKlienta = statusKlienta;
		this.nrSzafki = nrSzafki;
		this.idKlubu = idKlubu;
	}


}
