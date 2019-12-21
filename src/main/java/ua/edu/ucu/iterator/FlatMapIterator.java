package ua.edu.ucu.iterator;

import ua.edu.ucu.function.IntToIntStreamFunction;

import java.util.Iterator;

public class FlatMapIterator implements Iterator<Integer> {

    private IntToIntStreamFunction f;
    private Iterator<Integer> iter;
    private StreamIterator sIter;

    public FlatMapIterator(Iterator<Integer> iter, IntToIntStreamFunction f) {
        this.iter = iter;
        this.f = f;
        this.sIter = new StreamIterator();
    }
    @Override
    public boolean hasNext() {
        if (sIter.hasNext()) {
            return true;
        }
        else {
            if (!sIter.hasNext() && iter.hasNext()) {
                sIter=  new StreamIterator(f.applyAsIntStream(iter.next())
                        .toArray());
                return true;
            }
            if (!sIter.hasNext() && !iter.hasNext()) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return sIter.next();
    }

}
