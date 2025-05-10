package de.ostfalia.aud.ss25.a0;

import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IMember;

import java.time.LocalDate; //Importiert LocalDate, um später darauf zuzugreifen.


/**
 * @author Rick Kunze, Robin Iffland
 * @version 1.0
 * @Description Klasse zum Speichern von Mitgliedern und deren Daten.
 */
public class Member implements IMember {
    private final String id;              //Deklaration der Klassenattribute, um die jeweiligen Mitgliedsdaten zu speichern.
    private final LocalDate joiningdate;
    private final String surname;
    private final String forename;
    private final Group group;
    private final boolean newsletter;

    /**
     * @param line (Übergibt eine eingelesene Zeile, welche die Daten zu jeweils einem Member enthält)
     */
    public Member(String line) {
        String[] sections = line.split(";");    //Teilt den übergebenen String in die einzelnen Daten auf, Trennzeichen Semikolon.
        this.id = sections[0].trim();       //ID wird einfach als String übernommen.
        this.joiningdate = LocalDate.parse(sections[1].trim()); //Der Datum-String wird in ein Datum konvertiert.
        this.surname = sections[2].trim();  //...
        this.forename = sections[3].trim(); //...
        this.group = Group.valueOf(sections[4].trim()); //Der String für die Gruppe wird in den passenden Enum-Wert konvertiert.
        this.newsletter = Boolean.parseBoolean(sections[5].trim()); //Der String für den Newsletter wird in einen boolean-Wert konvertiert.
    }

    /**
     * @param id
     * @param joiningdate
     * @param surname
     * @param forename
     * @param group
     * @param newsletter
     * @Description Konstruktor für den Fall, dass die Argumente direkt übergeben werden.
     */
    public Member(String id, LocalDate joiningdate, String surname, String forename, Group group, boolean newsletter) {
        this.id = id;
        this.joiningdate = joiningdate;
        this.surname = surname;
        this.forename = forename;
        this.group = group;
        this.newsletter = newsletter;
    }

    /**
     * @return this.id (Die ID des Members)
     */
    public String getId() { //Gibt die ID zurück.
        return this.id;
    }

    /**
     * @return this.joiningdate (Das Beitrittsdatum des Members)
     */

    public LocalDate getJoiningdate() {  //Gibt das Beitrittsdatum zurück.
        return this.joiningdate;
    }

    /**
     * @return this.surname (Gibt den Namen des Members zurück)
     */
    public String getSurname() { //Gibt den Namen zurück.
        return this.surname;
    }

    /**
     * @return this.surname (Gibt den Vornamen des Nutzers zurück)
     */
    public String getForename() { //Gibt den Vornamen zurück.
        return this.forename;
    }

    /**
     * @return this.group (Gibt die Membergruppe zurück)
     */
    public Group getGroup() { //Gibt die jeweilige Gruppe zurück.
        return this.group;
    }

    /**
     * @return this.newsletter (Gibt zurück, ob der Member den Newsletter abonniert hat)
     */
    public boolean hasNewsletter() { //Gibt zurück, ob der Newsletter abonniert wurde.
        return this.newsletter;
    }

    @Override
    /**
     * @param o (Stellt ein anderes Member-Objekt dar)
     * @return boolean (Prüft auf Gleichheit der ID und gibt den entsprechenden Boolean-Wert zurück)
     */
    public boolean equals(Object o) {    //Gibt zurück, ob es sich um den gleichen Member handelt.
        if (o instanceof Member objectToCompare) { //Das Casten war nötig, um auf die Klassenmethode getId() zuzugreifen.
            //Das Casten war nötig, um auf die Klassenmethode getId() zuzugreifen.
            return this.getId().equalsIgnoreCase(objectToCompare.getId());
        }
        return false;
    }

    @Override   //Gibt die Daten im CSV-Format zurück.
    /**
     * @return String (Gibt die Zusammenfassung der Memberdaten als String zurück)
     */
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s",
                this.id,
                this.joiningdate.toString(),
                this.surname,
                this.forename,
                this.group.toString(),
                Boolean.toString(this.newsletter));
    }

    @Override
    /**
     * @param o (Objekt der Klasse Member)
     * @return Integer (wird in späterer Aufgabe implementiert)
     */
    public int compareTo(IMember o) {
        return id.compareTo(o.getId());
    }

    @Override
    public int hashCode(){
        throw new UnsupportedOperationException("Unused method in Member.");
    }
}
