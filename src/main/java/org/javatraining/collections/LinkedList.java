package org.javatraining.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by alexander on 4/25/16.
 */
public class LinkedList<T> implements List<T> {
    private static class Element<T> {
        T data;
        Element<T> next;
    }

    private Element<T> tail;

    public LinkedList() {
    }

    public int size() {
        if (tail == null) {
            return 0;
        }
        int size = 0;
        Element<T> e = tail;
        while (e != null) {
            size++;
            e = e.next;
        }
        return size;
    }

    public boolean isEmpty() {
        if (tail == null) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (tail == null) {
            return true;
        }
        if(!o.getClass().equals(tail.data.getClass())) {
            throw new ClassCastException();
        }
        Element<T> element = tail;
        while (element != null) {
            if (o.equals(element.data)) {
                return true;
            } else {
                element = element.next;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        int size = size();
        T[] array = (T[]) new Object[size];
        int i = 0;
        Element<T> e = tail.next;
        while (e != null) {
            array[i] = e.data;
            e = e.next;
            i++;
        }
        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        int size = size();
        if (a.length == size) {
            int i = 0;
            Element<T> e = tail.next;
            while (e != null) {
                a[i] = (T1) e.data;
                e = e.next;
                i++;
            }
        } else if (a.length > size) {
            int i = 0;
            Element<T> e = tail.next;
            while (e != null) {
                a[i] = (T1) e.data;
                e = e.next;
                i++;
            }
            for (int j = i; j < a.length; j++) {
                a[j] = null;
            }
        } else {
            T1[] array = (T1[]) new Object[size];
            int i = 0;
            Element<T> e = tail.next;
            while (e != null) {
                array[i] = (T1) e.data;
                e = e.next;
                i++;
            }
            return array;
        }
        return a;
    }

    public boolean add(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        Element<T> e = new Element<T>();
        e.data = t;
        e.next = null;
        if (tail == null) {
            tail = e;
        } else {
            Element<T> elem = tail;
            while (elem.next != null) {
                elem = elem.next;
            }
            elem.next = e;
        }
        return true;
    }

    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        Element<T> e = tail;
        if (o.equals(e.data)) {
            tail = e.next;
            return true;
        }

        while (e.next != null) {
            if (o.equals(e.next.data)) {
                e.next = e.next.next;
                return true;
            } else {
                e = e.next;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        tail.next = null;
    }

    public T get(int index) {
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException();
        }
        int position = 0;
        Element<T> e = tail;
        while (position < index) {
            position++;
            e = e.next;
        }
        return e.data;
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        int position = 0;

        Element<T> newElement = new Element<T>();
        newElement.data = element;
        if (tail == null) {
            tail = newElement;
            newElement.next = null;
        } else {
            Element<T> e = tail;
            for (int i = 0; i < index - 1; i++) {
                e = e.next;
            }
            newElement.next = e.next;
            e.next = newElement;
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        Element<T> e = tail.next;
        Element<T> previousElement = tail;
        if (index == 0) {
            if (tail.next != null) {
                previousElement = tail.next;
                tail = tail.next;
            } else {
                return null;
            }
        }
        /*
        else if(index==(size()-1)){
            for(int i=0;i<index;i++){
                e=e.next;
            }
            e.next=null;
            last=e;
            previousElement=e;
        }
        else {

            for (int i = 0; i < index; i++) {
                e=e.next;
            }
            previousElement=e.next;
            e.next=e.next.next;
        }*/
        return previousElement.data;
    }

    public int indexOf(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        Element<T> e = tail;
        int i = 0;
        while (e != null) {
            if (o.equals(e.data)) {
                return i;
            }
            e = e.next;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) throw new NullPointerException();
        Element<T> e = tail;
        int i = 0;
        int lastIndex = -1;
        while (e != null) {
            if (o.equals(e.data)) {
                lastIndex = i;
            }
            e = e.next;
            i++;
        }
        return lastIndex;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

}


