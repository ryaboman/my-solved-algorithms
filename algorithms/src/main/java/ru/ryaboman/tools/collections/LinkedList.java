package ru.ryaboman.tools.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<TYPE> implements List<TYPE> {

    private Node<TYPE> head;
    private Node<TYPE> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<TYPE> node = head;
        while (true){
            if (node == null) {
                return false;
            }
            if (node.getValue() == o) {
                return true;
            }
            node = node.getNext();
        }
    }

    @Override
    public Iterator<TYPE> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(TYPE type) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends TYPE> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends TYPE> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public TYPE get(int index) {
        return null;
    }

    @Override
    public TYPE set(int index, TYPE element) {
        return null;
    }

    @Override
    public void add(int index, TYPE element) {

    }

    @Override
    public TYPE remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<TYPE> listIterator() {
        return null;
    }

    @Override
    public ListIterator<TYPE> listIterator(int index) {
        return null;
    }

    @Override
    public List<TYPE> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
