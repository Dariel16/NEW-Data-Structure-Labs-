package llPositionalList;

import interfaces.PLIteratorMaker;
import interfaces.Position;
import interfaces.PositionalList;

import java.util.Iterator;

public class PositionIteratorMaker<E> implements PLIteratorMaker<E>{

    @Override
    public Iterator<Position<E>> makeIterator(PositionalList<E> pl) {
        return (Iterator<Position<E>>) ((LinkedPositionalList<E>)pl).new BackwardElementIterator();
    }

}
