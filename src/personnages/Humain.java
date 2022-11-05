package personnages;

public class Humain {
	protected String nom;
	protected String boissonFavori;
	protected int monnaie;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(int monnaie) {
		this.monnaie = monnaie;
	}
	public Humain(String nom, String boissonFavori, int monnaie) {
		super();
		this.nom = nom;
		this.boissonFavori = boissonFavori;
		this.monnaie = monnaie;
	}
	private String prendreParole() {
		return "("+nom+")" + " - ";
	}
	public void parler(String texte) {
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
	public int gagnerArgent(int gain) {
		monnaie+=gain;
		return monnaie;
	}
	public int perdreArgent(int perte) {
		monnaie-=perte;
		return monnaie;
	}
	
}
