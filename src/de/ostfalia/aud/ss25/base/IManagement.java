package de.ostfalia.aud.ss25.base;

/**
 * Das Interface legt die Methoden für die Verwaltung der Vereinsmitglieder
 * fest. Es ist ein Teil der Aufgaben, die im Labor zu Algorithmen und
 * Datenstrukturen implementiert werden.
 * 
 * Bitte beachten:
 * 
 * 1) Die Datensätze können aus einer csv-Textdatei oder aus einem String-Array
 * eingelesen werden. Die einzelnen Member-Objekte sind zeilenweise zu lesen und
 * die einzelnen Daten stets durch " ; " voneinader getrennt. Zum Beispiel:
 * 
 * id; joiningdate; surname; forename; group; newsletter 
 * GI-103383; 1987-10-29; Silva-Ponte; Adam; STUDENT; true 
 * GI-105031; 1986-07-28; Wolfenbüttel; Björn;EMERITUS; false
 * 
 * 2) Die Implementierung dieses Interfaces muss mit mindestens folgenden
 * Konstruktoren vervollständigt werden:
 * 
 * 2a) public Management(String[] data): für das einlesen der Vereinsmitglieder
 * aus einem Array
 * 
 * 2b) public Management(String dateiName) throws IOException: für das einlesen
 * der Vereinsmitglieder aus einee csv-Datei
 * 
 * 3) Es ist garantiert, dass die Daten sowohl aus dem Array als auch aus der
 * Datei eindeutige IDs beinhaltet. Es bedarf in diesem Fall keine
 * Überprüfung stattfinden, ob die ID bereits vorhanden ist. Die Methode
 * insert() muss dagegen diese Überprüfung durchführen, um sicherzustellen, dass
 * die Vereinsmitglieder weiterhin einzigartig bleiben.
 * 
 * @author D. Dick
 * @since SS 2025
 *
 */
public interface IManagement {

    /**
     * Fügt ein Element in die Auflistung hinzu, sofern noch kein gleiches Element
     * bereits existiert. Die Methode garantiert daher, dass kein zwei
     * Vereinsmitglieder mit der gleichen ID gibt.
     * 
     * @param member das hinzuzufügende Element
     * @return true, falls das Element eingefügt werden konnte; ansonsten false
     */
    public boolean insert(IMember member);

    /**
     * Löscht das gewünschte Element aus der Auflistung.
     *
     * @param id Die eindeutige Identifikation des zu löschenden Elements
     * @return true, wenn das Element gelöscht werden konnte; ansonsten false.
     */
    public boolean remove(String id);

    /**
     * Sucht nach einem Datensatz mit dem angegebenen Schlüssel.
     * 
     * @param id die gesuchte Mitgliedsnummer
     * @return den gefundenen Datensatz, oder null, wenn der Schlüsselwert nicht
     *         gefunden werden konnte.
     */
    public IMember search(String id);

    /**
     * 
     * Liefert eine Auflistung mit allen zum Suchkriterium passenden Elementen.
     *
     * @param surname  der Vorname des gesuchten Vereinsmitgliedes
     * @param forename der Nachname des gesuchten Vereinsmitgliedes
     * @return eine Auflistung mit allen passenden Elemente oder eine leere
     *         Auflistung, wenn nichts gefunden werden konnte
     */
    public IAlgoCollection<IMember> members(String surname, String forename);

    /**
     * 
     * Liefert eine Auflistung mit allen zum Suchkriterium passenden Elementen.
     *
     * @param group die gesuchte Art der Mitgliedschaft
     * @return eine Auflistung mit allen passenden Elemente oder eine leere
     *         Auflistung, wenn nichts gefunden werden konnte
     */
    public IAlgoCollection<IMember> members(Group group);

    /**
     * Liefert die Gesamtanzahl der Elemente in der Auflistung zurück
     *
     * @return die Gesamtanzahl der Elemente
     */
    public int size();

    /**
     * Liefert die Anzahl der Elemente der angegebenen Art der Mitgliedschaft
     * zurück.
     * 
     * @param group die gesuchte Art der Mitgliedschaft
     * @return Anzahl der Datensätze mit dem angegebenen Suchkriterium
     */
    public int size(Group group);

    /**
     * Liefert den Index, also die Position, wo das gesuchte Element in die
     * Auflistung gespeichert ist. Diese Methode ist insbesondere für die Aufgabe 4
     * (Hashtabelle) wichtig.
     *
     * @param id Die eindeutige Identifikation des zu suchenden Elements
     * @return der Index, also die Position, wo das gesuchte Element in die
     *         Auflistung gespeichert ist
     */
    public int indexOf(String id);

    /**
     * Liefert ein Array mit allen gültigen Elementen der Auflistung zurück in der
     * Reihenfolge, wie sie in die Auflistung vorkommen.
     *
     * @return ein Array mit allen gültigen Elementen der Auflistung, oder ein
     *         leeres Array
     */
    public IMember[] toArray();

    /**
     * Liefert ein String mit allen gültigen Elementen der Auflistung zurück in der
     * Reihenfolge, wie sie in die Auflistung vorkommen.
     *
     * @return ein String mit allen gültigen Elementen der Auflistung oder einen
     *         leeren String, wenn die Auflistung leer ist.
     */
    @Override
    public String toString();

    /*
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * Default Methoden. Werden erst in Aufgabe 3 überschrieben
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */

    /**
     * Die Höhe des Baums
     *
     * @return die Höhe des Baumes
     */
    public default int height() {
	return 0;
    }
}
