package luke.algorithm.practice.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/*
 * Stack Min:
 * How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackWithMin extends Stack<Integer> {
    Stack<Integer> min = new Stack<>();

    public void push(int v) {
        if (min.isEmpty() || v <= min()) {
            min.push(v);
        }
        super.push(v);
    }

    public Integer pop() {
        int v = super.pop();
        if (v == min()){
            min.pop();
        }
        return v;
    }

    public int min() {
        if (min.isEmpty()) {
            throw new EmptyStackException();
        }
        return min.peek();
    }
}
