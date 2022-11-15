package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int monnaie) {
		super(nom,"the", monnaie);
	}
	
	public int seFaireExtorquer() {
		int monnaieStolen=this.getMonnaie();
		this.perdreArgent(this.getMonnaie());
		parler("J’ai tout perdu! Le monde est vraiment trop injuste !......");
		return monnaieStolen;
	}
	public void recevoir(int argent) {
		this.gagnerArgent(argent);
		parler(argent+" sous ! Je te remercie généreux donateur!");
	}

	@Override
	public String toString() {
		return "Commercant [nom=" +getNom() + ", boissonFavori=" + this.getBoissonFavori() + ", monnaie=" + this.getMonnaie() + "]";
	}
	
}
