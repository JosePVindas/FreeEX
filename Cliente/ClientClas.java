package Cliente;

public class ClientClas {
	
	private String name;
	private String password;
	private String Range;
	private int position;
	
	

	public ClientClas(String Name, String Image, String Leader, int Days) {
		this.name = Name;
		this.Imag = Image;
		this.leader = Leader;
		this.days = Days;

	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
		
	public void setImage(String Image) {
		this.Imag = Image;
	}
	
	public String getImage() {
		return Imag;
	}
	
	public void setLeader(String Leader) {
		this.leader = Leader;
	}
	
	public String getLeader() {
		return leader;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int Days) {
		this.days = Days;
	}
	
	public String getClients() {
		return clients;
	}
	
	public void setClients(String Clients) {
		this.clients = Clients;
	}
	
	public String getRequest() {
		return Request;
	}
	
	public void setRequest(String Request) {
		this.Request = Request;
	}
	
}