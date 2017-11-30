package sopra.ecom.model;

public enum Statut {

	PANIER("role.panier"), VALIDE("role.valide"), PREPARATION("role.preparation"), LIVRAISON("role.livraison"), LIVRE("role.livre");
	
	private final String label;
	
	private Statut(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
