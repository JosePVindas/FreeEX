package Resources;
public abstract class Resource {

	protected String Name;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return Name;
	}

	public boolean isIcon() {
		return icon;
	}

	public int getTime() {
		return time;
	}

	protected boolean icon;
	protected int x;
	protected int y;
	protected int time;

	protected static void loop(int time) {
		while (time > 0) {
			time--;

		}

	}

}