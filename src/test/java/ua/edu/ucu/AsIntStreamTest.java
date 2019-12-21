package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AsIntStreamTest {

    private IntStream intStream;


    @Test
    public void testAverage() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        double expResult = 1.0;
        double result = intStream.average();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testMax() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int expResult = 3;
        int result = intStream.max();
        assertEquals(expResult, result);
    }

    @Test
    public void testMin() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int expResult = -1;
        int result = intStream.min();
        assertEquals(expResult, result);
    }

    @Test
    public void testCount() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        long expResult = 5;
        long result = intStream.count();
        assertEquals(expResult, result);
    }

    @Test
    public void testSum() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int expResult = 5;
        int result = intStream.sum();
        assertEquals(expResult, result);
    }

    @Test
    public void testToArray() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = intStream.toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testFilter() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int[] expResult = {1, 2, 3};
        int[] result = intStream.filter(x -> x > 0).toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMap() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int[] expResult = {1, 0, 1, 4, 9};
        int[] result = intStream.map(x -> x * x).toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testFlatMap() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int[] expResult = {-2, -1, 0, -1, 0, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4};
        int[] result = intStream.flatMap(x -> AsIntStream.of(x - 1, x, x + 1)).toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testReduce() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        int expResult = 10;
        int result = intStream.reduce(5, (sum, x) -> sum += x);
        assertEquals(expResult, result);
    }
}
