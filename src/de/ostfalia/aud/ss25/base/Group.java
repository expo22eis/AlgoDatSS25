
/**
 * @author D. Dick
 * @since SS 2025
 *
 */
public enum Group {
    /**
     * Vollzahlendes Mitglied
     */
    FULL("Vollzahlende"), 
    
    /**
     * Mitglied im Ruhestand
     */
    EMERITUS("Ruhestand"), 
    
    /**
     * Besondere Art der Mitgliedschaft
     */
    REDUCED("Ermäßigt"), 
    
    /**
     * Studentisches Mitglied 
     */
    STUDENT("Studierende");

    private String name;

    private Group(String name) {
	this.name = name;
    }

    public String getName() {
	return this.name;
    }
}