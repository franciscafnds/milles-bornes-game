package cartes;

public enum Type {
	FEU("feu rouge", "feu vert", "vehicule prioritaire"),
	ESSENCE("panne d'essence", "essence", "citerne d'essence"),
	CREVAISON("crevaison", "roue de secours", "increvable"),
	ACCIDENT("accident", "reparations", "as du volant");
	
	private String botte;
	private String attaque;
	private String parade;

	Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;

	}

	public String getBotte() {
		return botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

}

// gettype.getattaque alors j'aurai toute les attaques cad la premiere colonne
// si je fais FEU.getattaque alors j'aurai feu rouge !
