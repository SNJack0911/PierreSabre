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
		parler(victime.getNom()+", si tu tiens à la vie donne moi ta bourse !");
		reputation+=1;
		int monnaieGain=victime.seFaireExtorquer();
		this.gagnerArgent(monnaieGain);
		parler("J’ai piqué les "+monnaieGain+" sous de "+victime.getNom()+", ce qui me fait "+this.getMonnaie()+" sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		int monnaieStolen=this.getMonnaie();
		this.perdreArgent(this.getMonnaie());
		reputation-=1;
		parler("J’ai perdu mon duel et mes "+monnaieStolen+" sous, snif... J'ai déshonoré le clan de "+clan);
		return monnaieStolen;
	}
	public void gagner(int gain) {
		this.gagnerArgent(gain);
		reputation+=1;
		parler("Ce ronin pensait vraiment battre "+getNom()+" du clan de "+clan+" ? Je l'ai dépouillé de ses "+gain+" sous.)");
	}
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de "+this.clan);
	}
	@Override
	public String toString() {
		return "Yakuza [clan=" + clan + ", reputation=" + reputation + ", nom=" + getNom() + ", boissonFavori="
				+ this.getBoissonFavori() + ", monnaie=" + this.getMonnaie() + "]";
	}
	
}
