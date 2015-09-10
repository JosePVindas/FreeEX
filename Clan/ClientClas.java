package Clan;

public class ClientClas {
	
	private String name = null;
	private String password= null;
	private String range = "Recluta";
	private int positionx = 0;
	private int positiony = 0;
	private String possessiona = null;
	private String possessiond = null;
	private String action = null;
	

	public ClientClas(String Name, String Password, String Range, int Positionx, int Positiony, String Possessiona, String Possessiond, String Action) {
		this.name = Name;
		this.password = Password;
		this.range = Range;
		this.positionx = Positionx;
		this.positiony = Positiony;
		this.possessiona = Possessiona;
		this.possessiond = Possessiond;
		this.action = Action;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String Name) {
		this.name = Name;
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