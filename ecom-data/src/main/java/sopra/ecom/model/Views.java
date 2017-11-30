package sopra.ecom.model;

public class Views {
	public static class Common {

	}

	public static class Client extends Common {

	}

	public static class ProduitCommande extends Common {
		
	}
	public static class Commande extends Common {
		
	}
	public static class ClientUtilisateur extends Client {
		
	}
	
	
	public static class Module extends Common {
		
	}
	public static class Utilisateur extends Common {

	}

	public static class ModuleWithFormations extends Module {

	}
	
	public static class ModuleFormation extends Common {
		
	}
	public static class Categorie extends Common {

	}

	public static class Formation extends Common {

	}
	
	public static class FormationWithModules extends Formation {

	}
	
	public static class Eleve extends Common {

	}
	
	public static class EleveWithModules extends Eleve {
		
	}
	
	public static class Formateur extends Common {

	}
	
	public static class FormateurWithEleves extends Common {

	}
	
	public static class Ressource extends Common {

	}
	
	public static class Salle extends Common {

	}
}
