package ua.edu.ucu.iterator;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;

public class FilterIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private IntPredicate p;
    private Integer nextEl;

    public FilterIterator(Iterator<Integer> iter, IntPredicate p) {
        this.iter = iter;
        this.p = p;
        this.nextEl = null;
    }

    public boolean hasNext() {
        if (nextEl != null) {
            return true;
        }
        while (iter.hasNext()) {
            Integer i = iter.next();
            if (p.test(i)) {
                nextEl = i;
                return true;
            }
        }
        return false;
    }

    public Integer next() {
        Integer res = nextEl;
        nextEl = null;
        return res;
    }



}
