package luke.algorithm.practice.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PrimeTest {

    @Test
    public void primeList(){
        Integer[] p = {2,3,5,7,11,13,17,19,23};
        assertArrayEquals(p, Prime.primeList(25).toArray(new Integer[p.length]));
    }

}