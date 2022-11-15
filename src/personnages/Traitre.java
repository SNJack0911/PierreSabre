package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	
	private int niveauTraitre;

	public Traitre(String seigneur, String nom, String boissonFavori, int monnaie) {
		super(seigneur, nom, boissonFavori, monnaie);
	}
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : "
				+niveauTraitre+".Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if(niveauTraitre<3) {
			int argentRanconner=(int) (commercant.getMonnaie()*0.2);
			commercant.perdreArgent(argentRanconner);
			this.gagnerArgent(argentRanconner);
			niveauTraitre++;
			parler("Si tu veux ma protection contre les Yakuzas "
					+", il va falloir payer ! Donner-moi "
					+argentRanconner+" sous ou gare a toi !");
			commercant.parler("Tout de suite grand "+this.getNom()+".");	
		}else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de\r\n"
					+ "me démasquer !");
		}
	}
	public void faireLeGentil() {
		if(nbConnaissance<1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}else {
			Random know= new Random();
			int knowPerson=know.nextInt(0,nbConnaissance);
			String nomAmi= memoire[knowPerson].getNom();
			int don = this.getMonnaie()*1/20;
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami\r\n"
					+ "avec "+nomAmi+".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant "+don+" sous.");
			memoire[knowPerson].gagnerArgent(don);
			this.perdreArgent(don);
			memoire[knowPerson].parler("Merci "+this.getNom()+". Vous êtes quelqu'un de bien.");
			if (niveauTraitre>1) {
				niveauTraitre--;
			}
		}
	}
}
