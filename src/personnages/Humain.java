package personnages;

public class Humain {
	private String nom;
	private String boissonFavori;
	private int monnaie;
	protected int nbConnaissance;
	protected Humain[] memoire;
	private int nbConnaissanceMax=30;
	
	public String getNom() {
		return nom;
	}
	public int getMonnaie() {
		return monnaie;
	}
	public String getBoissonFavori() {
		return boissonFavori;
	}
	public Humain(String nom, String boissonFavori, int monnaie) {
		super();
		this.nom = nom;
		this.boissonFavori = boissonFavori;
		this.monnaie = monnaie;
		this.nbConnaissance=0;
		memoire=new Humain[nbConnaissanceMax];
	}
	private String prendreParole() {
		return "("+nom+")" + " - ";
	}
	protected void parler(String texte) {
		System.out.println(prendreParole()  + texte );
	}
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle "+nom+" et j’aime boire du "+boissonFavori);
	} 
	public void boire() {
		parler("Mmmm, un bon verre de "+boissonFavori+" ! GLOUPS !");
	}
	public void acheter(String bien, int prix) {
		if (monnaie>=prix) {
			parler("J'ai "+monnaie+" sous en poche. Je vais pouvoir m'offrir une "+ bien +" à "+ prix +" sous" );
			monnaie-=prix;
		}else {
			parler("Je n'ai plus que "+monnaie+" sous en poche. Je ne peux même pas m'offrir un "+bien+" à " +prix+" sous");
		}
	}
	protected int gagnerArgent(int gain) {
		monnaie+=gain;
		return monnaie;
	}
	protected int perdreArgent(int perte) {
		monnaie-=perte;
		return monnaie;
	}
	public void faireConnaissanceAvec(Humain humain2) {
		this.direBonjour();
		humain2.repondre(this);
		this.memoriser(humain2);
	}
	private void memoriser(Humain humain) {
		if (nbConnaissance<nbConnaissanceMax) {
			memoire[nbConnaissance]=humain;
			nbConnaissance+=1;
		}else {
			for (int i =0;i<nbConnaissanceMax-1;i++) {
				memoire[i]=memoire[i+1];
			}
			memoire[nbConnaissanceMax-1]=humain;
		}
	}
	private void repondre(Humain humain) {
		this.direBonjour();
		this.memoriser(humain);
	}
	public void listerConnaissance() {
		System.out.print(prendreParole()+"Je connais beaucoup de monde dont : ");
		for(int i =0;i<nbConnaissance;i++) {
			System.out.print(memoire[i].nom+", ");
		}
		System.out.println();
	}

}
