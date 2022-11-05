package personnages;

public class Ronin extends Humain {

	private int honneur=1;
	
	public Ronin(String nom, String boissonFavori, int monnaie) {
		super(nom, boissonFavori, monnaie);
	}
	public void donner(Commercant beneficiaire) {
		int somme = (int) (monnaie*0.1);
		parler( beneficiaire.nom+" prend ces "+somme+" sous.");
		beneficiaire.recevoir(somme);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = honneur*2;
		if (force>=adversaire.getReputation()) {
			honneur+=1;
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
			parler("Je t’ai eu petit yakusa!");
			this.gagnerArgent(adversaire.perdre());
		}else {
			honneur-=1;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(monnaie);
			this.perdreArgent(monnaie);
		}
	}
}
