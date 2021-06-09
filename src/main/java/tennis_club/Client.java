package tennis_club;

public class Client {

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

	public static final class Builder {

		private int idKlienta;
		private String imie;
		private String nazwisko;
		private String nrTelefonu;
		private String statusKlienta;
		private String nrSzafki;
		private int idKlubu;

		public Builder withIdKlienta(int idKlienta) {
			this.idKlienta = idKlienta;
			return this;
		}

		public Builder withImie(String imie) {
			this.imie = imie;
			return this;
		}

		public Builder withNazwisko(String nazwisko) {
			this.nazwisko = nazwisko;
			return this;
		}

		public Builder withNrTelefonu(String nrTelefonu) {
			this.nrTelefonu = nrTelefonu;
			return this;
		}

		public Builder withStatusKlienta(String statusKlienta) {
			this.statusKlienta = statusKlienta;
			return this;
		}

		public Builder withNrSzafki(String nrSzafki) {
			this.nrSzafki = nrSzafki;
			return this;
		}

		public Builder withIdKlubu(int idKlubu) {
			this.idKlubu = idKlubu;
			return this;
		}

		public Client build() {
			Client client = new Client();
			client.idKlienta = this.idKlienta;
			client.imie = this.imie;
			client.nazwisko = this.nazwisko;
			client.nrTelefonu = this.nrTelefonu;
			client.statusKlienta = this.statusKlienta;
			client.nrSzafki = this.nrSzafki;
			client.idKlubu = this.idKlubu;

			return client;
		}
	}

}
