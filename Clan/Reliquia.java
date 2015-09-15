package Clan;

public class Reliquia {
		private String Radio;
		private String Image;
		private String positionx;
		private String positiony;

		public Reliquia(String radio, String Imag, String Positionx, String Positiony) {
			this.Radio = radio;
			this.Image = Imag;
			this.positionx = Positionx;
			this.positiony = Positiony;
		}
		
		public String getImage() {
			return Image;
		}
		
		public void setImage(String Imag) {
			this.Image = Imag;
		}
		
		public String getRadio() {
			return Radio;
		}
		
		public void setName(String radio) {
			this.Radio = radio;
		}
		
		public String getPosotionx() {
			return positionx;
		}
		
		public void setPositionx(String Positionx) {
			this.positionx = Positionx;
		}
		
		public String getPosotiony() {
			return positiony;
		}
		
		public void setPositiony(String Positiony) {
			this.positiony = Positiony;
		}

	}