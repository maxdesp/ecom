package sopra.ecom.exception;

@SuppressWarnings("serial")
public class FormationAppException extends RuntimeException{

	public class ModuleException extends FormationAppException {
		
	}
	
	public class PersonneException extends FormationAppException {
		
	}
}