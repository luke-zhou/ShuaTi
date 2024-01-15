package luke.algorithm.practice.dynamic;

public class StepsPuzzle {
    public static void main(String[] args) {
        int result = solve_recursive(8000);
        System.out.println(result);
    }

    public static int solve_recursive(int n) {
        if (n == 0) return 1;

        int result = 0;

        for (int i = 1; i <= 3; i++) {
            if (n - i >= 0) {
                result += solve(n - i);
            }
        }

        return result;
    }

    public static int solve(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        solve_dynamic(n, memo);
        return memo[n];
    }

    public static int solve_dynamic(int n, int[] memo) {
        if (memo[n] == 0) {
            for (int i = 1; i <= 3; i++) {
                if (n - i >= 0) {
                    memo[n] += solve_dynamic(n - i, memo);
                }
            }
        }

        return memo[n];
    }
}
