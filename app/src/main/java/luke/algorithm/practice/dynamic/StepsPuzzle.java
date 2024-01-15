package luke.algorithm.practice.dynamic;

public class StepsPuzzle {
    public static void main(String[] args) {
        int result = solve(5);
        System.out.println(result);
    }

    public static int solve(int n) {
        if (n == 0) return 1;

        int result = 0;

        for(int i=1; i <=3; i++){
            if (n - i >= 0) {
                result += solve(n - i);
            }
        }

        return result;
    }
}
