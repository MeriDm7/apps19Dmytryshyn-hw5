package ua.edu.ucu.iterator;

import java.util.Iterator;
import ua.edu.ucu.function.IntUnaryOperator;

public class MapIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private IntUnaryOperator o;

    public MapIterator(Iterator<Integer> iter, IntUnaryOperator o) {
        this.iter = iter;
        this.o = o;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Integer next() {
        return o.apply(iter.next());
    }
}
