package internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/* Class that represents the usage of internationalization */
public class Internationalization {
	
	public String getLanguage(int index, String needTranslation) {
		String word = "";
		
		if(index == 0) {
			Locale locale = new Locale("en", "IE");
			ResourceBundle resourceBundle = ResourceBundle.getBundle("internationalization/en_IE", locale);
			word = resourceBundle.getString(needTranslation);
		}
		
		else if(index == 1) {
			Locale locale = new Locale("pt", "BR");
			ResourceBundle resourceBundle = ResourceBundle.getBundle("internationalization/pt_BR", locale);
			word = resourceBundle.getString(needTranslation);
		}
		
		return word;
	}
}
