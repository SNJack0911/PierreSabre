package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, String boissonFavori, int monnaie) {
		super(nom,boissonFavori, monnaie);
	}
	
	public int seFaireExtorquer() {
		int monnaieStolen=monnaie;
		this.perdreArgent(monnaie);
		parler("J’ai tout perdu! Le monde est vraiment trop injuste !......");
		return monnaieStolen;
	}
	public void recevoir(int argent) {
		this.gagnerArgent(argent);
		parler(argent+" sous ! Je te remercie généreux donateur!");
	}

	@Override
	public String toString() {
		return "Commercant [nom=" + nom + ", boissonFavori=" + boissonFavori + ", monnaie=" + monnaie + "]";
	}
	
}
