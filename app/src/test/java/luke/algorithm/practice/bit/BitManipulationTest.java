package luke.algorithm.practice.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitManipulationTest {

    @Test
    public void insert(){
        int result = BitManipulation.insert(0x400, 0x13, 2, 6);
        assertEquals(0x44c, result);
    }

}