package ua.edu.ucu.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class StreamIterator implements Iterator<Integer> {

    private ArrayList<Integer> arr;
    private int index = 0;

    public StreamIterator(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public StreamIterator(int[] lst) {
        this.arr = new ArrayList<Integer>();
        for (int i: lst) {
            arr.add(i);
        }
    }

    public StreamIterator() {
        this.arr = new ArrayList<Integer>();
    }

    @Override
    public boolean hasNext() {
        if (index < arr.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        Integer  res = arr.get(index);
        index += 1;
        return res;
    }
}
