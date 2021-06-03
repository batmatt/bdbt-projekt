package tennis_club;

public class Client {

	private int clientId;
	private String clientName;
	private String clientSurname;
	
	public Client (int clientId, String clientName, String clientSurname) {
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientSurname = clientSurname;
	}
	
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSurname() {
		return clientSurname;
	}

	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientSurname=" + clientSurname + "]";
	}	
}
