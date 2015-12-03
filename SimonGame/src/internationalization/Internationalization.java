package internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/* Class that represents the usage of internationalization */
public class Internationalization {
	/* Method to get the word and translate it */
	public String getTranslation(int index, String needTranslation) {
		String word = "";
		
		/* If language selected is English */
		if(index == 0) {
			/* Locale is English from Ireland */
			Locale locale = new Locale("en", "IE");
			/* Use the English property file to translate */
			ResourceBundle resourceBundle = ResourceBundle.getBundle("internationalization/en_IE", locale);
			/* Get the word which needs translation and translate it */
			word = resourceBundle.getString(needTranslation);
		}
		
		/* If language selected is Portuguese */
		else if(index == 1) {
			/* Locale is Portuguese from Brazil */
			Locale locale = new Locale("pt", "BR");
			/* Use the Portuguese property file to translate */
			ResourceBundle resourceBundle = ResourceBundle.getBundle("internationalization/pt_BR", locale);
			/* Get the word which needs translation and translate it */
			word = resourceBundle.getString(needTranslation);
		}
		
		/* Return the new word */
		return word;
	}
}
