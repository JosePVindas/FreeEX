package Clan;
/** Es el molde de las reliquias, posee sus atributos y metodos para accesar a ellos*/
public class Reliquia {
		private String Radio;
		private String Image;
		private String positionx;
		private String positiony;
		private String Clan;

		public Reliquia(String radio, String Imag, String Positionx, String Positiony, String clan) {
			this.Radio = radio;
			this.Image = Imag;
			this.positionx = Positionx;
			this.positiony = Positiony;
			this.Clan = clan;
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
		public String getClan() {
			return Clan;
		}
		
		public void setClan(String clan) {
			this.Clan = clan;
		}

	}