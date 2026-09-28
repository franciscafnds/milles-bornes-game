package cartes;

public class JeuDeCartes {
	private Configuration[] configurations = new Configuration[19];
	
	public JeuDeCartes() {
		configurations[0] = new Configuration(new Borne(25), 10);
		configurations[1] = new Configuration(new Borne(50), 10);
		configurations[2] = new Configuration(new Borne(75), 10);
		configurations[3] = new Configuration(new Borne(100), 12);
		configurations[4] = new Configuration(new Borne(200), 4); 
		configurations[5] = new Configuration(new Parade(Type.FEU), 14); //feu vert
		configurations[6] = new Configuration(new FinLimite(), 6); //fin limite
		configurations[7] = new Configuration(new Parade(Type.ESSENCE), 6); //essence
		configurations[8] = new Configuration(new Parade(Type.CREVAISON), 6); //roue de secours
		configurations[9] = new Configuration(new Parade(Type.ACCIDENT), 6); //reparations
		configurations[10] = new Configuration(new Attaque(Type.FEU), 5); //feu rouge
		configurations[11] = new Configuration(new DebutLimite(), 4); //limite 50
		configurations[12] = new Configuration(new Attaque(Type.ESSENCE), 3); //panne d'essence
		configurations[13] = new Configuration(new Attaque(Type.CREVAISON), 3); //crevaison
		configurations[14] = new Configuration(new Attaque(Type.ACCIDENT), 3); //accident
		configurations[15] = new Configuration(new Botte(Type.FEU), 1); //prioritaire
		configurations[16] = new Configuration(new Botte(Type.ESSENCE), 1); //citerne
		configurations[17] = new Configuration(new Botte(Type.CREVAISON), 1); //increvable
		configurations[18] = new Configuration(new Botte(Type.ACCIDENT), 1); //as du volant
	}
	
	private class Configuration extends Carte{
		int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
		
		public Carte getCarte() {
			return carte;
		}
		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}
	
	public String affichageJeuDeCartes() {
		StringBuilder jdc = new StringBuilder("JEU :\n");
		for (Configuration configuration : configurations) {
			jdc.append(configuration.getNbExemplaires())
			.append(" ")
			.append(configuration.getCarte())
			.append("\n");
		}
		return jdc.toString();
	}
	
	public Carte[] donnerCartes() {
		// Pour connaitre le nombre de cartes on parcourt une premiere fois toutes les cartes
		int nbCartes = 0;
		for (Configuration configuration : configurations) {
			nbCartes += configuration.getNbExemplaires();
		}
		
		Carte[] cartes = new Carte[nbCartes];
		int i = 0;

		// On parcourt une nouvelle fois pour mettre chaque carte dans le tableau
		for (Configuration configuration : configurations) {
			for (int j = 0; j<configuration.getNbExemplaires(); j++) {
				cartes[i] = configuration.getCarte();
				i++;
			}
		}
		return cartes;
	}
/* 
 public boolean checkCount() {
		// TODO Auto-generated method stub
		return false;
	}
*/
	
}
