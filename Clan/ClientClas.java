package Clan;

public class ClientClas {
	
	private String ClientName;
	private String password;
	private String range = "Recluta";
	private int positionx;
	private int positiony;
	private String possessiona;
	private String possessiond;
	private String action;
	

	public ClientClas(String Name, String Password, String Range, int Positionx, int Positiony, String Possessiona, String Possessiond, String Action) {
		this.ClientName = Name;
		this.password = Password;
		this.range = Range;
		this.positionx = Positionx;
		this.positiony = Positiony;
		this.possessiona = Possessiona;
		this.possessiond = Possessiond;
		this.action = Action;
	}
	
	public String getName() {
		return ClientName;
	}
	
	public void setName(String Name) {
		this.ClientName = Name;
	}
	
	public void setPassword(String Password) {
		this.password = Password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRange(String Range) {
		this.range = Range;
	}
	
	public String getRange() {
		return range;
	}
	
	public int getPosotionx() {
		return positionx;
	}
	
	public void setPositionx(int Positionx) {
		this.positionx = Positionx;
	}
	
	public int getPosotiony() {
		return positiony;
	}
	
	public void setPositiony(int Positiony) {
		this.positiony = Positiony;
	}
	
	public void setPossessiona(String Possessiona) {
		this.possessiona = Possessiona;
	}
	public String getPossessiona() {
		return possessiona;
	}
	
	public void setPossessiond(String Possessiond) {
		this.possessiond = Possessiond;
	}
	public String getPossessiond() {
		return possessiond;
	}
	
	public void setAction(String Action) {
		this.action = Action;
	}
	public String getAction() {
		return action;
	}
}