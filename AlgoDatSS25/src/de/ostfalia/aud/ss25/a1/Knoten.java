package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.base.IMember;

public class Knoten {

    private IMember element;
    private Knoten next;

    protected Knoten(IMember m) {

        this.element = m;
        this.next = null;
    }

    protected void setNext(Knoten k) {
        this.next = k;
    }

    protected Knoten getNext() {
        return this.next;
    }

    protected IMember getElement() {
        return this.element;
    }
}
