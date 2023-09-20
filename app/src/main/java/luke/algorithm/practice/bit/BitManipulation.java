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

    public static int smallestNext(int n){
        int oneBitCount = 0;
        int p = -1;
        for(int i = 0; i< Integer.SIZE ; i++){
            if ((n & 1) == 0 && oneBitCount > 0){
                p = i;
                break;
            }else if ((n & 1) == 1){
                oneBitCount ++;
            }
            n >>>=1;
        }

        n = n | 1;
        n <<=p;
        int mask = ~0;
        mask<<=(oneBitCount-1);
        mask = ~mask;
        return n|mask;
    }

    public static int largestPrevious(int n){
        int oneBitCount = 0;
        int p = -1;
        for(int i = 0; i< Integer.SIZE ; i++){
            if ((n & 1) == 1 && oneBitCount < i){
                p = i;
                break;
            }else if ((n & 1) == 1){
                oneBitCount ++;
            }
            n >>>=1;
        }

        n = n - 1;
        n <<=p;
        int mask = ~0;
        mask<<=(oneBitCount+1);
        mask = ~mask;
        mask <<= p-oneBitCount-1;
        return n|mask;
    }

    public static int bitDiffCount(int a, int b){
        int c = a ^ b;
        int count = 0;
        while (c != 0){
            c = c & (c-1);
            count++;
        }
        return count;
    }
}
