package luke.algorithm.practice.bit;

public class BitManipulation {
    public static int insert(int n, int m, int i, int j){
        int all1 = ~0;
        int leftMask = all1 << (j+1);
        int rightMask = 1<<i - 1;
        int mask = leftMask | rightMask;

        n = n & mask;
        m = m << i;
        return n | m;
    }

    public static int flipBit(int n){
        if (n == ~0) return Integer.SIZE;
        int currentLen = 0;
        int previousLen = 0;
        int maxLen = 1;
        while(n != 0){
            if ((n & 1) == 1){
                currentLen++;
            }else{
                maxLen = Math.max(maxLen, previousLen + currentLen+1);
                previousLen = (n&2)==2 ? currentLen : 0;
                currentLen = 0;
            }
            n >>>= 1;
        }

        return maxLen;
    }
}
