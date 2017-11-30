package sopra.ecom.trash;

public enum Statut {
	ORDINATEUR("type.ordinateur"), USB("type.usb"), SOURIS("type.souris"), PROJECTEUR("type.projecteur");

	private final String label;

	private Statut(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
