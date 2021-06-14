package tennis_club;

public class Kort {

	private int idKortu;
	private String nawierzchnia;
	private String statusKortu;
	private int idPlacowki;

	public Kort() {

	}

	public Kort(int idKortu, String nawierzchnia, String statusKortu, int idPlacowki) {
		super();
		this.idKortu = idKortu;
		this.nawierzchnia = nawierzchnia;
		this.statusKortu = statusKortu;
		this.idPlacowki = idPlacowki;
	}

	public int getIdKortu() {
		return idKortu;
	}

	public void setIdKortu(int idKortu) {
		this.idKortu = idKortu;
	}

	public String getNawierzchnia() {
		return nawierzchnia;
	}

	public void setNawierzchnia(String nawierzchnia) {
		this.nawierzchnia = nawierzchnia;
	}

	public String getStatusKortu() {
		return statusKortu;
	}

	public void setStatusKortu(String statusKortu) {
		this.statusKortu = statusKortu;
	}

	public int getIdPlacowki() {
		return idPlacowki;
	}

	public void setIdPlacowki(int idPlacowki) {
		this.idPlacowki = idPlacowki;
	}
}
