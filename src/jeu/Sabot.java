package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot <C extends Carte> implements Iterable<C>{
	private C[] pioche;
	private int nbCartes;
	private int nombreOperations = 0;
	
	public Sabot(C...pioche) {
		this.pioche = pioche;
		nbCartes = pioche.length;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(C carte) {
		if (nbCartes >= pioche.length) {
		throw new IllegalStateException("Le sabot est plein");
		}
		pioche[nbCartes] = carte;
		nbCartes++;
		nombreOperations++;
		}
	
	public C piocher() {
		Iterator<C> it = iterator();
		C carte = it.next();
		it.remove();
		return carte;
	}
	
	@Override
	public Iterator<C> iterator(){
		return new SabotIterator();
	}
	
	private class SabotIterator implements Iterator<C>{
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationsReference = nombreOperations;
		
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		public C next() {
			verificationConcurrence();
			if (hasNext()) {
				C carte = pioche[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i=indiceIterateur-1; i<nbCartes-1; i++) {
				pioche[i] = pioche[i+1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nombreOperations++;
			nombreOperationsReference++;
		}
		
		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
		
	}
	
}
