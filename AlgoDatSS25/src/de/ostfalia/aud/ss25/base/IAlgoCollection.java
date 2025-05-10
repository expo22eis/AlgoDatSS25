package de.ostfalia.aud.ss25.base;

import java.util.Comparator;

/**
 * Das Interface legt die Methoden für die Datenstrukturen fest, die im Labor zu
 * Algorithmen und Datenstrukturen implementiert werden.
 *
 * Bitte beachten:
 *
 * @param <IMember> Der hier generische Datentyp E wird in der entsprechenden
 * Implementierung der Datenstruktur durch IMember ersetzt.
 *
 * @author D. Dick
 * @since SS 2025
 *
 */
public interface IAlgoCollection<IMember> {

    /**
     * Einfügen eines Elements in die Collection.
     *
     * @param m das hinzufügende Objekt. Sie können davon ausgehen, dass der Wert
     * nicht null ist
     * @return true, falls das Element in die Auflistung hinzugefügt wurde;
     * ansonsten false
     */
    public boolean add(IMember m);

    /**
     * Löscht das gewünschte Element aus der Auflistung, sofern es vorhanden ist.
     *
     * @param m das zu löschende Objekt. Sie können davon ausgehen, dass der Wert
     * nicht null ist
     * @return true, falls das Objekt gelöscht werden konnte; false ansonsten
     */
    public boolean remove(IMember m);

    /**
     * Liefert das zuerst gefundene Objekt, das zur Anfrage passt.
     *
     * @param m das zu findende Objekt. Sie können davon ausgehen, dass der Wert
     * nicht null ist
     * @return das gewünschte Objekt, falls vorhanden; ansonsten null
     */
    public IMember get(IMember m);

    /**
     * Liefert eine Sammlung mit allen Objekten zurück, die zum Suchkriterium
     * passen.
     *
     * @param c der Comparator für die Vergleiche
     * @param m das zu suchende Objekt. Sie können davon ausgehen, dass der Wert
     * nicht null ist
     * @return eine Auflistung mit allen gefundenen Objekte. Falls kein Element
     * gefunden wird, wird eine leere Sammlung (size == 0) zurückgeliefert.
     */
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m);

    /**
     * Liefert den Index (die Position in der Auflistung) des zuerst gefundenen
     * Objekts, das zur Anfrage passt.
     *
     * @param m das zu suchende Objekt. Sie können davon ausgehen, dass der Wert
     * nicht null ist
     * @return der Index des Objekts (die Position in der Auflistung) oder -1, falls
     * das Objekt nicht gefunden werden konnte.
     */
    public int indexOf(IMember m);

    /**
     * Liefert die Gesamtanzahl der Elemente in der Auflistung zurück
     *
     * @return die Gesamtanzahl der Elemente
     */
    public int size();

    /**
     * Liefert die Anzahl der Elemente in der Auflistung zurück, die zum
     * Suchkriterium passen
     *
     * @param c der Comparator für die Vergleiche
     * @param m das zu suchende Objekt. Sie können davon ausgehen, dass der Wert
     * nicht null ist
     * @return die Anzahl der Elemente, die zum Suchkriterium passen
     */
    public int size(Comparator<IMember> c, IMember m);

    /**
     * Sortiert die Daten wie es im Comparator gewünscht. Beachten Sie bitte, dass
     * diese Methode tatsächlich nur bei der Aufgabe 2 (Sorties Array) überschrieben
     * werden muss.
     *
     * @param c der Comparator für die Vergleiche
     *
     */
    public default void sort(Comparator<IMember> c) {
    }

    /**
     *
     * Liefert ein Array mit allen gültigen Elementen der Auflistung zurück in der
     * Reihenfolge, wie sie in die Auflistung vorkommen. Es ist garantiert, dass das
     * Array keine null-Werte beinhaltet.
     *
     * @return ein Array mit allen gültigen Elementen der Auflistung, oder ein
     * leeres Array
     */
    public IMember[] toArray();

    /**
     * Liefert ein String mit allen gültigen Elementen der Auflistung zurück in der
     * Reihenfolge, wie sie in die Auflistung vorkommen.
     *
     * @return ein String mit allen gültigen Elementen der Auflistung oder einen
     * leeren String, wenn die Auflistung leer ist.
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
