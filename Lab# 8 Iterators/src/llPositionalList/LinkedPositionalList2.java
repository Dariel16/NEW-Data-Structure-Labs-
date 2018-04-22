package llPositionalList;

import interfaces.PLIteratorMaker;
import interfaces.Position;
import interfaces.PositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList2<E> implements PositionalList<E> {
    private static class DNode<E> implements Position<E> {
        private E element;
        private LinkedPositionalList2.DNode<E> prev, next;
        public E getElement() {
            return element;
        }
        public DNode(E element, LinkedPositionalList2.DNode<E> prev, LinkedPositionalList2.DNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        public DNode(E element) {
            this(element, null, null);
        }
        public DNode() {
            this(null, null, null);
        }
        public void setElement(E element) {
            this.element = element;
        }
        public LinkedPositionalList2.DNode<E> getPrev() {
            return prev;
        }
        public void setPrev(LinkedPositionalList2.DNode<E> prev) {
            this.prev = prev;
        }
        public LinkedPositionalList2.DNode<E> getNext() {
            return next;
        }
        public void setNext(LinkedPositionalList2.DNode<E> next) {
            this.next = next;
        }
        public void clean() {
            element = null;
            prev = next = null;
        }
    }

    private LinkedPositionalList2.DNode<E> header, trailer;
    private int size;
    private PLIteratorMaker<E> iteratorMaker;
    private Iterator<Position<E>> posIterator;


    public LinkedPositionalList2() {
        header = new LinkedPositionalList2.DNode<>();
        trailer = new LinkedPositionalList2.DNode<>();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public LinkedPositionalList2(PLIteratorMaker<E> iMaker) {
        this();
        this.iteratorMaker = iMaker;
    }

    private LinkedPositionalList2.DNode<E> validate(Position<E> p) throws IllegalArgumentException {
        try {
            LinkedPositionalList2.DNode<E> dp = (LinkedPositionalList2.DNode<E>) p;
            if (dp.getPrev() == null || dp.getNext() == null)
                throw new IllegalArgumentException("Invalid internal node.");

            boolean isSameList = false;
            for (Position pos: positions()) {
                if (pos == p) isSameList = true;
            }

            if (!isSameList)
                throw new IllegalArgumentException("Position not from this list");

            return dp;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid position type.");
        }
    }

    private Position<E> position(LinkedPositionalList2.DNode<E> dn) {
        if (dn == header || dn == trailer)
            return null;
        return dn;
    }

    private LinkedPositionalList2.DNode<E> addBetween(LinkedPositionalList2.DNode<E> b, LinkedPositionalList2.DNode<E> a, E e) {
        LinkedPositionalList2.DNode<E> n = new LinkedPositionalList2.DNode<>(e, b, a);
        b.setNext(n);
        a.setPrev(n);
        size++;
        return n;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        return position(validate(p).getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        return position(validate(p).getNext());
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(header, header.getNext(), e);
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(trailer.getPrev(), trailer, e);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e)
            throws IllegalArgumentException {
        LinkedPositionalList2.DNode<E> dp = validate(p);
        return addBetween(dp.getPrev(), dp, e);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e)
            throws IllegalArgumentException {
        LinkedPositionalList2.DNode<E> dp = validate(p);
        return addBetween(dp, dp.getNext(), e);
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        LinkedPositionalList2.DNode<E> dp = validate(p);
        E etr = dp.getElement();
        dp.setElement(e);
        return etr;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        LinkedPositionalList2.DNode<E> dp = validate(p);
        E etr = dp.getElement();
        LinkedPositionalList2.DNode<E> b = dp.getPrev();
        LinkedPositionalList2.DNode<E> a = dp.getNext();
        b.setNext(a);
        a.setPrev(b);
        dp.clean();
        size--;
        return etr;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return new LinkedPositionalList2.PositionIterable();
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterator<Position<E>> iterator2() {
        return iteratorMaker.makeIterator(this);
    }


    // Implementation of Iterator and Iterable...
    private class PositionIterator implements Iterator<Position<E>> {
        private LinkedPositionalList2.DNode<E> cursor = header.getNext(),
                recent = null;
        @Override
        public boolean hasNext() {
            return cursor != trailer;
        }

        @Override
        public Position<E> next() throws NoSuchElementException {
            if (!hasNext())
                throw new NoSuchElementException("No more elements.");
            recent = cursor;
            cursor = cursor.getNext();
            return recent;
        }

        public void remove() throws IllegalStateException {
            if (recent == null)
                throw new IllegalStateException("remove() not valid at this state of the iterator.");
            LinkedPositionalList2.DNode<E> b = recent.getPrev();
            LinkedPositionalList2.DNode<E> a = recent.getNext();
            b.setNext(a);
            a.setPrev(b);
            recent.clean();
            recent = null;
            size--;          // important because we are removing recent directly....
        }

    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator =
                new LinkedPositionalList2.PositionIterator();
        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext())
                throw new NoSuchElementException("No more elements.");
            return posIterator.next().getElement();
        }

        public void remove() throws IllegalStateException {
            posIterator.remove();
        }
    }

    public class BackwardElementIterator implements Iterator<E>{
        private LinkedPositionalList2.DNode<E> cursor = trailer.getPrev(), recent = null;
        public BackwardElementIterator() {
        }
        @Override
        public boolean hasNext() {
            return cursor != header;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext())
                throw new NoSuchElementException("No more elements.");
            recent = cursor;
            cursor = cursor.getPrev();
            E etr = recent.getElement();
            return etr;
        }
        
        public void remove() throws IllegalStateException {
            if (recent == null)
                throw new IllegalStateException("remove() not valid at this state of the iterator.");
            LinkedPositionalList2.DNode<E> b = recent.getPrev();
            LinkedPositionalList2.DNode<E> a = recent.getNext();
            b.setNext(a);
            a.setPrev(b);
            recent.clean();
            recent = null;
            size--;
        }
    }

  private class PositionIterable implements Iterable<Position<E>> {

        @Override
        public Iterator<Position<E>> iterator() {
            return new LinkedPositionalList2.PositionIterator();
        }

    }

    private class ElementIteratorMaker<E> implements PLIteratorMaker<E> {

        @Override
        public Iterator<Position<E>> makeIterator(PositionalList<E> pl) {
            return (Iterator<Position<E>>) new ElementIterator();
        }
    }

    private class BackwardElementIteratorMaker<E> implements PLIteratorMaker<E> {

        @Override
        public Iterator<Position<E>> makeIterator(PositionalList<E> pl) {
            return (Iterator<Position<E>>) new BackwardElementIterator();
        }
    }
}
