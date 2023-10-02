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

    @Test
    public void bitDiffCount(){
        int result = BitManipulation.bitDiffCount(29, 15);
        assertEquals(2, result);
        result = BitManipulation.bitDiffCount(0b11111, 0b00000);
        assertEquals(5, result);
        result = BitManipulation.bitDiffCount(0b10101, 0b10101);
        assertEquals(0, result);
    }

    @Test
    public void shiftTest(){
        int number = 0xd000ffff;
        System.out.println(number);
        int result = number << 1;
        System.out.println(Integer.toHexString(result));
        System.out.println(result);

        number = 0x90000000;
        int result1 = number >> 1;
        int result2 = number >>> 1;
        System.out.println(Integer.toHexString(result1));
        System.out.println(Integer.toHexString(result2));

        System.out.println(Integer.toHexString(~1));
    }

    @Test
    public void bitwiseSwap(){
        int n = 0xaaaaaaaa;
        assertEquals(0x55555555, BitManipulation.bitwiseSwap(n));
    }



}