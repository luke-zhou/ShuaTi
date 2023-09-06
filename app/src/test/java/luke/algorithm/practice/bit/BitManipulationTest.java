package luke.algorithm.practice.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitManipulationTest {

    @Test
    public void insert(){
        int result = BitManipulation.insert(0x400, 0x13, 2, 6);
        assertEquals(0x44c, result);
    }

    @Test
    public void flipBit(){
        int result = BitManipulation.flipBit(0b11011101111);
        assertEquals(8, result);
    }

    @Test
    public void smallestNext(){
        int result = BitManipulation.smallestNext(0b11011001111100);
//        System.out.println(Integer.toBinaryString(result));
        assertEquals(0b11011010001111, result);
    }

    @Test
    public void largestPrevious(){
        int result = BitManipulation.largestPrevious(0b100110001110011);
//        System.out.println(Integer.toBinaryString(result));
        assertEquals(0b100110001101110, result);
    }

}