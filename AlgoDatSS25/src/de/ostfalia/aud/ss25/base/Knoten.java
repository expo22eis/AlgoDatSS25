package de.ostfalia.aud.ss25.base;

public class Knoten {

    private IMember element;
    private Knoten next;

    public Knoten(IMember m) {

        this.element = m;
        this.next = null;
    }

    public void setNext(Knoten k) {
        this.next = k;
    }

    public Knoten getNext() {
        return this.next;
    }

    public IMember getElement() {
        return this.element;
    }
}
