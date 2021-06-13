package tennis_club;


public class Adres {

	private int idAdresu;
	private String ulica;
	private String nrDzialki;
	private String miejscowosc;
	private String kodPocztowy;
	private String nrLokalu;
	
	
	public Adres() {
		
	}
	
	public Adres(int idAdresu, String ulica, String nrDzialki, String miejscowosc, String kodPocztowy,
			String nrLokalu) {
		super();
		this.idAdresu = idAdresu;
		this.ulica = ulica;
		this.nrDzialki = nrDzialki;
		this.miejscowosc = miejscowosc;
		this.kodPocztowy = kodPocztowy;
		this.nrLokalu = nrLokalu;
	}

	
	public int getIdAdresu() {
		return idAdresu;
	}
	
	public void setIdAdresu(int idAdresu) {
		this.idAdresu = idAdresu;
	}
	
	public String getUlica() {
		return ulica;
	}
	
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
	public String getNrDzialki() {
		return nrDzialki;
	}
	
	public void setNrDzialki(String nrDzialki) {
		this.nrDzialki = nrDzialki;
	}
	
	public String getMiejscowosc() {
		return miejscowosc;
	}
	
	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}
	
	public String getKodPocztowy() {
		return kodPocztowy;
	}
	
	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}
	
	public String getNrLokalu() {
		return nrLokalu;
	}
	
	public void setNrLokalu(String nrLokalu) {
		this.nrLokalu = nrLokalu;
	}
}
