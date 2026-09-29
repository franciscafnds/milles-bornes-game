package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());
	
	// 5.2.a
	public void questionA() {
		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println("Je pioche " + carte);
		}
	}
	
	// 5.2.b
	public void questionB() {
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
		// ou for (Carte carte : sabot)
			System.out.println("Je pioche " + iterator.next());
			iterator.remove();
		}
	}
	
	/*On ajoute à la boucle b) un appel à piocher. Une exception doit être
levée. De même, après avoir pioché une carte avant la boucle (afin
d’éviter un débordement du tableau cartes), insérer l’asDuVolant dans la
boucle doit lever une exception.
*/
	// 5.2.c
	public void questionC() {
		Carte cartePiochee = sabot.piocher();
		System.out.println("Je pioche " + cartePiochee);
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			System.out.println("Je pioche " + carte);
			iterator.remove();
			cartePiochee = sabot.piocher();
			sabot.ajouterCarte(new Botte(cartes.Type.ACCIDENT));
		}
		Iterator<Carte> iterator = sabot.iterator();
		System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
	}
	
	public static void main(String[] args) {
		TestSabot testPioche = new TestSabot();
		//testPioche.questionA();
		//testPioche.questionB();
		testPioche.questionC();
	}
}
