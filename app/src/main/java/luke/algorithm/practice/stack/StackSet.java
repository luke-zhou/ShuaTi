package luke.algorithm.practice.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackSet {
    int CAPACITY = 3;

    private Stack<Stack<Integer>> stackSet;

    public StackSet() {
        stackSet = new Stack<>();
    }

    public void push(int t) {
        if (stackSet.isEmpty()) {
            Stack s = new Stack<Integer>();
            s.push(t);
            stackSet.push(s);
        } else {
            Stack s = stackSet.peek();
            if (s.size() >= CAPACITY) {
                s = new Stack<Integer>();
                s.push(t);
                stackSet.push(s);
            } else {
                s.push(t);
            }
        }
    }

    public int pop() {
        if (stackSet.isEmpty()) throw new EmptyStackException();
        Stack<Integer> s = stackSet.peek();
        int v = s.pop();
        if (s.isEmpty()) stackSet.pop();

        return v;
    }

    public int peek() {
        if (stackSet.isEmpty()) throw new EmptyStackException();
        Stack<Integer> s = stackSet.peek();
        int v = s.peek();

        return v;
    }

    public int popAt(int index) {
        if (index >= stackSet.size()) throw new IndexOutOfBoundsException();
        Stack temp = new Stack<Stack<Integer>>();
        Stack<Integer> target = null;
        int size = stackSet.size();
        while (size > index) {
            if (target != null) temp.push(target);
            target = stackSet.pop();
            size--;
        }
        int v = target.pop();
        stackSet.push(target);
        while(!temp.isEmpty()){
            stackSet.push((Stack<Integer>) temp.pop());
        }

        return v;
    }
}
