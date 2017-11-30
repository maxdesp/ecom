package sopra.ecom.trash;

public enum Type {
	ORDINATEUR("type.ordinateur"), USB("type.usb"), SOURIS("type.souris"), PROJECTEUR("type.projecteur");

	private final String label;

	private Type(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
