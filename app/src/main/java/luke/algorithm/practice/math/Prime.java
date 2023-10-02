package luke.algorithm.practice.math;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    //Sieve of Eratosthenes
    public static ArrayList<Integer> primeList(int size){
        boolean[] flag = new boolean[size];
        for(int i = 2; i< size; i++){
            flag[i] = true;
        }

        int current = 2;
        while (current <= Math.sqrt(size)){
            crossOver(flag, current);

            while(!flag[++current]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =2; i < size; i++){
            if(flag[i]){
                result.add(i);
            }
        }
        return result;
    }

    private static void crossOver(boolean[] flag, int prime){
        for (int i = prime+prime; i < flag.length; i += prime)
            flag[i] = false;
    }
}
