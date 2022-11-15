package personnages;

public class Samourai extends Ronin {

	private String seigneur;
	public String getSeigneur() {
		return seigneur;
	}
	public Samourai(String seigneur,String nom, String boissonFavori, int monnaie) {
		super(nom, boissonFavori, monnaie);
		this.seigneur=seigneur;
	}
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur "+seigneur);
	}
	
	public void boire(String boisson) {
		parler("Qu'est-ce que je vais choisir comme boisson ?" 
				+" Tiens je vais prendre du "+boisson);
	}

}
