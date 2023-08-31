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
}
