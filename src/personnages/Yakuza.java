package personnages;

public class Yakuza extends Humain {
	
	private String clan;
	private int reputation;
	
	public Yakuza(String nom, String boissonFavori, int monnaie,String clan) {
		super(nom, boissonFavori, monnaie);
		this.clan=clan;
		this.reputation=0;
	}
	
	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.nom+", si tu tiens à la vie donne moi ta bourse !");
		reputation+=1;
		int monnaieGain=victime.seFaireExtorquer();
		this.gagnerArgent(monnaieGain);
		parler("J’ai piqué les "+monnaieGain+" sous de "+victime.nom+", ce qui me fait "+monnaie+" sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		int monnaieStolen=monnaie;
		this.perdreArgent(monnaie);
		reputation-=1;
		parler("J’ai perdu mon duel et mes "+monnaieStolen+" sous, snif... J'ai déshonoré le clan de "+clan);
		return monnaieStolen;
	}
	public void gagner(int gain) {
		this.gagnerArgent(gain);
		reputation+=1;
		parler("Ce ronin pensait vraiment battre "+nom+" du clan de "+clan+" ? Je l'ai dépouillé de ses "+gain+" sous.)");
	}
	@Override
	public String toString() {
		return "Yakuza [clan=" + clan + ", reputation=" + reputation + ", nom=" + nom + ", boissonFavori="
				+ boissonFavori + ", monnaie=" + monnaie + "]";
	}
	
}
