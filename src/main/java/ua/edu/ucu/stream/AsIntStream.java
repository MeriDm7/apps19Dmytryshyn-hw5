package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterator.FilterIterator;
import ua.edu.ucu.iterator.FlatMapIterator;
import ua.edu.ucu.iterator.MapIterator;
import ua.edu.ucu.iterator.StreamIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class AsIntStream implements IntStream {

    private Iterator<Integer> iter;


    private AsIntStream(int... values) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Integer i : values) {
            arr.add(i);
        }
        this.iter = new StreamIterator(arr);
    }

    private AsIntStream(Iterator<Integer> iter) {
        this.iter = iter;
    }

    private AsIntStream() {
        this.iter = new StreamIterator();
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }


    @Override
    public Double average() {
        int sum = 0;
        int counter = 0;
        while (iter.hasNext()) {
            sum += iter.next();
            counter += 1;
        }
        if (counter == 0) {
            throw new IllegalArgumentException();
        }
        return (double) sum / counter;
    }

    @Override
    public Integer max() {
        int[] arr = this.toArray();
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = arr[0];
        for (int i: arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        int[] arr = this.toArray();
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        int min = arr[0];
        for (int i: arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    @Override
    public long count() {
        long counter = 0;
        while (iter.hasNext()) {
            counter += 1;
            iter.next();
        }
        return counter;
    }

    @Override
    public Integer sum() {
        int[] arr = this.toArray();
        if (arr.length == 0) {
            throw  new IllegalArgumentException();
        }
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIterator(this.iter, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        while (iter.hasNext()) {
            action.accept(iter.next());
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(this.iter, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatMapIterator(this.iter, func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int res = identity;
        while (iter.hasNext()) {
            res = op.apply(res, iter.next());
        }
        return res;
    }

    @Override
    public int[] toArray() {
        ArrayList<Integer> lst = new ArrayList<>();
        while (iter.hasNext()) {
            lst.add(iter.next());
        }
        int[] arr = new int[lst.size()];
        int i = 0;
        for (int el: lst) {
            arr[i] = el;
            i++;
        }
        return arr;
    }

}
