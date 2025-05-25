package de.ostfalia.aud.ss25.base;

import java.time.LocalDate;

/**
 * Das Interface definiert ein Vereinsmitglied (Member) für die Aufgaben des
 * Labors zu Algorithmen und Datenstrukturen.
 * 
 * Bitte beachten:
 * 
 * 1) Die Implementierung dieses Interfaces muss mit mindestens dem Konstruktor
 * public Member(String) vervollständigt werden.
 * 
 * 2) Member-Objekte werden stets anhand deren Id miteinander verglichen.
 * 
 * 3) Vergleiche zwischen Strings sind stets ohne Berücksichtigung von
 * Groß/Kleinschreibung (case insensitive) durchzuführen.
 * 
 * @author D. Dick
 * @since SS 2025
 *
 */
public interface IMember extends Comparable<IMember> {
    /**
     * Liefert die eindeutige Identifikation des Vereinsmitglieds.
     *
     * @return die ID (der Schlüssel)
     */
    public String getId();

    /**
     * Liefert das Eintrittsdatums des Mitglieds in dem Verein. Das Datum wird in
     * dem ISO-8601 Format zurückgegeben (z.B. 2025-12-31)
     *
     * @return das Eintrittsdatums
     */
    public LocalDate getJoiningdate();

    /**
     * Liefert der Nachname des Vereinsmitglieds.
     *
     * @return der Nachname
     */
    public String getSurname();

    /**
     * Liefert der Vorname des Vereinsmitglieds.
     *
     * @return der Vorname
     */
    public String getForename();

    /**
     * Liefert die Beitragsgruppe des Vereinsmitglieds.
     *
     * @return die Beitragsgruppe
     */
    public Group getGroup();

    /**
     * Ob der Empfang von Newsletter erteilt wurde oder nicht.
     *
     * @return true, wenn Newsletter empfangen werden sollen; ansonsten false
     */
    public boolean hasNewsletter();

    /**
     * Vergleicht zwei Vereinsmitglieder anhand deren ID.
     *
     * @param o das zu vergleichende Member (Vereinsmitglied)
     * @return true, falls die IDs identisch sind; false ansonsten.
     */
    @Override
    public boolean equals(Object o);

    /**
     * Liefert ein String in dem Format
     * "key;joiningdate;surname;forename;group;newsletter"
     *
     * @return ein String mit den Informationen des Vereinsmitglieds (Member). Die
     *         einzelne Werte sind dabei durch ; getrennt.
     */
    @Override
    public String toString();
}