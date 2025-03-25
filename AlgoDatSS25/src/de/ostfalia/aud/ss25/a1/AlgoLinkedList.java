package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.base.Knoten;

import java.util.Comparator;

public class AlgoLinkedList implements IAlgoCollection<IMember> {

    private Knoten startknoten;

    private int size;

    public AlgoLinkedList() { //Konstruktor

    }

    public boolean add(IMember m) {

        if (this.startknoten == null) {  //Wenn das erste Element hinzugefügt wird,
            this.startknoten = new Knoten(m); //wird es im Startknoten gespeichert.
            size = 1;
            return true;
        }
        Knoten letzterKnoten = this.startknoten;
        while (letzterKnoten.getNext() != null) { //Geht solange die Liste durch, bis es keinen nächsten Knoten gibt.
            letzterKnoten = letzterKnoten.getNext();
        }
        letzterKnoten.setNext(new Knoten(m)); //Dann wird dem letzten Knoten ein neuer Knoten angehängt.
        size++;
        return true;
    }

    public boolean remove2(IMember m){
        if (this.startknoten == null){
            return false;
        }
        Knoten k = startknoten;
        if( k.getElement().equals(m)){
            this.startknoten = k.getNext();
            return true;
        }
        while (k.getNext() != null){
            if (k.getNext().getElement().equals(m)){
                if (k.getNext().getNext() == null){
                    k.setNext(null);
                    return true;
                }
                else{
                    k.setNext(k.getNext().getNext());
                    return true;
                }
            }
        }
        return false;
    }
    public boolean remove(IMember m) {

        Knoten letzterKnoten = this.startknoten;

        if (letzterKnoten.getElement().equals(m)) {
            this.startknoten = this.startknoten.getNext();
            this.size--;
            return true;
        }
        while (letzterKnoten.getNext() != null) {  //Liste wird durchgegangen

            if (letzterKnoten.getNext().getElement().equals(m)) { //Wenn der nächste Knoten den gesuchten Member enthält...

                //Wird der übernächste Member an den aktuellen gehangen, sodass der gesuchte Member entfernt wird.
                if (letzterKnoten.getNext().getNext() == null){
                    letzterKnoten.setNext(null);
                    this.size--;
                    return true;
                }
                letzterKnoten.setNext(letzterKnoten.getNext().getNext());
                this.size--; //Wenn ein Element entfernt wurde, verringert sich auch die Größe der Liste um 1.
                return true;
            }

            letzterKnoten = letzterKnoten.getNext();
        }

        return false;
    }

    public IMember get(IMember m) {

        if (this.startknoten == null) {
            return null;
        }
        if (this.startknoten.getElement().equals(m)) { //Wenn der Startknoten gesucht ist,
            return this.startknoten.getElement();//wird dieser zurückgegeben
        }
        Knoten letzterKnoten = this.startknoten;
        while (letzterKnoten.getNext() != null) { //Liste wird durchlaufen
            if (letzterKnoten.getElement().equals(m)) { //Wenn der Knoten das gesuchte Element enthält,
                return letzterKnoten.getElement(); //wird dieses zurückgegeben
            }
            letzterKnoten = letzterKnoten.getNext();
        }
        if (letzterKnoten.getElement().equals(m)){
            return letzterKnoten.getElement();
        }
        return null; //ansonsten wird null zurückgegeben
    }

    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {

        IAlgoCollection<IMember> liste = new AlgoLinkedList(); //Neue Liste zum Speichern wird erstelt

        Knoten letzterKnoten = this.startknoten;

        //Wenn das Startelement mit dem gesuchten Element vergleichbar ist, wird es der Liste hinzugefügt.
        if (c.compare(m, letzterKnoten.getElement()) == 0) {
            liste.add(letzterKnoten.getElement());
        }

        while (letzterKnoten.getNext() != null) { //Liste wird durchlaufen
            letzterKnoten = letzterKnoten.getNext();

            //Wenn das Listenelement vergleichbar ist, wird es der Liste hinzugefügt.
            if (c.compare(m, letzterKnoten.getElement()) == 0) {
                liste.add(letzterKnoten.getElement());
            }
        }
        return liste; //Am Ende wird die Liste zurückgegeben.
    }

    public int indexOf(IMember m) {

        int index = 0; //Variable zum Speichern des Index wird erstellt.

        Knoten letzterKnoten = this.startknoten;
        //Wenn der Startknoten das gesuchte Element ist, wird logischerweise Index = 0 zurückgegeben.
        if (letzterKnoten.getElement().equals(m)) {
            return index;
        }
        while (letzterKnoten.getNext() != null) { //Liste wird durchlaufen
            index++;
            letzterKnoten = letzterKnoten.getNext();
            if (letzterKnoten.getElement().equals(m)) {  //Wenn das Element gefunden wurde, wird dessen Index zurückgegeben.
                return index;
            }
        }
        return -1; //Wenn nicht, wird -1 zurückgegeben.
    }

    public int size() {
        return this.size; //Gibt die Anzahl der Elemente der Liste zurück.
    }

    public int size(Comparator<IMember> c, IMember m) {

        int matchSize = 0;
        Knoten letzterKnoten = this.startknoten;
        //Wenn der Startknoten ein vergleichbares Element enthält, wird matchSize um 1 erhöht.
        if (c.compare(m, letzterKnoten.getElement()) == 0) {
            matchSize++;
        }
        while (letzterKnoten.getNext() != null) { //Liste wird durchlaufen
            letzterKnoten = letzterKnoten.getNext();
            //Wenn ein vergleichbares Element gefunden wurde, wird matchSize um 1 erhöht.
            if (c.compare(m, letzterKnoten.getElement()) == 0) {
                matchSize++;
            }
        }
        return matchSize; //Die Anzahl der erfolgreichen Vergleiche wird zurückgegeben.
    }

    public IMember[] toArray() {

        IMember[] array = new IMember[this.size()]; //Erstellt ein Array der benötigten Größe
        //Wenn es keine Elemente gibt, wird ein leeres Array zurückgegeben.
        if (this.startknoten == null) {
            return array;
        }
        int index = 0;

        Knoten letzterKnoten = this.startknoten;
        array[index] = letzterKnoten.getElement();
        while (letzterKnoten.getNext() != null) { //Liste wird durchlaufen und jedes Element dem Array hinzugefügt.
            index++;
            letzterKnoten = letzterKnoten.getNext();
            array[index] = letzterKnoten.getElement();
        }
        return array;
    }

    public String toString() {

        String auflistung = "";

        if (this.startknoten == null) {
            return auflistung;
        }
        Knoten letzterKnoten = this.startknoten;
        auflistung += letzterKnoten.getElement().toString();

        //Liste wird durchlaufen und alle Elemente werden "toStringed" und dem String hinzugefügt.
        while (letzterKnoten.getNext() != null) {
            letzterKnoten = letzterKnoten.getNext();
            auflistung += "\n";
            auflistung += letzterKnoten.getElement().toString();
        }
        return auflistung;
    }

    public IAlgoCollection<IMember> getMembersByNames(IMember m) {

        IAlgoCollection<IMember> liste = new AlgoLinkedList(); //Neue Liste zum Speichern wird erstelt

        Knoten letzterKnoten = this.startknoten;

        //Wenn das Startelement den gleichen Namen hat, wird es in der Liste gespeichert.
        if (letzterKnoten.getElement().getForename().equals(m.getForename())
                && letzterKnoten.getElement().getSurname().equals(m.getSurname())) {
            liste.add(letzterKnoten.getElement());
        }

        while (letzterKnoten.getNext() != null) { //Liste wird durchlaufen
            letzterKnoten = letzterKnoten.getNext();

            //Wenn das Listenelement den gleichen namen hat, wird es der Liste hinzugefügt.
            if (letzterKnoten.getElement().getForename().equals(m.getForename())
                    && letzterKnoten.getElement().getSurname().equals(m.getSurname())) {
                liste.add(letzterKnoten.getElement());
            }
        }
        return liste; //Am Ende wird die Liste zurückgegeben.
    }

    public IAlgoCollection<IMember> getMembersByGroup(IMember m) {

        IAlgoCollection<IMember> liste = new AlgoLinkedList(); //Neue Liste zum Speichern wird erstelt

        Knoten letzterKnoten = this.startknoten;

        //Wenn das Startelement die gleiche Gruppe hat, wird es in der Liste gespeichert.
        if (letzterKnoten.getElement().getGroup() == m.getGroup()) {
            liste.add(letzterKnoten.getElement());
        }

        while (letzterKnoten.getNext() != null) { //Liste wird durchlaufen
            letzterKnoten = letzterKnoten.getNext();

            //Wenn das Listenelement die gleiche Gruppe hat, wird es der Liste hinzugefügt.
            if (letzterKnoten.getElement().getGroup() == m.getGroup()) {
                liste.add(letzterKnoten.getElement());
            }
        }
        return liste; //Am Ende wird die Liste zurückgegeben.
    }

}
