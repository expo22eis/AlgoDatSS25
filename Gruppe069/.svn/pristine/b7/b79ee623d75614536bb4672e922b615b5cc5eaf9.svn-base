package de.ostfalia.aud.ss25.a4;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;

import java.util.Comparator;

public class SimpleLinkedList implements IAlgoCollection<IMember> {

    private static class Node {
        IMember data;
        Node next;

        Node(IMember data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    @Override
    public boolean add(IMember m) {
        if (contains(m)) {
            return false;
        }
        Node newNode = new Node(m);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(IMember m) {
        Node prev = null, current = head;
        while (current != null) {
            if (current.data.equals(m)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public IMember get(IMember m) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(m)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        SimpleLinkedList result = new SimpleLinkedList();
        Node current = head;
        while (current != null) {
            if (c.compare(current.data, m) == 0) {
                result.add(current.data);
            }
            current = current.next;
        }
        return result;
    }

    @Override
    public int indexOf(IMember m) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(m)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (c.compare(current.data, m) == 0) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    @Override
    public IMember[] toArray() {
        IMember[] array = new IMember[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append("\n");
            current = current.next;
        }
        return sb.toString();
    }

    private boolean contains(IMember m) {
        return indexOf(m) != -1;
    }
}
