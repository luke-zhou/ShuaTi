package luke.algorithm.practice.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public boolean isEmpty() {
        return output.isEmpty() && input.isEmpty();
    }

    public int size() {
        return input.size() + output.size();
    }

    public void add(int v) {
        input.push(v);
    }

    public int remove() {
        if(isEmpty()) throw new NoSuchElementException();
        if (output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek() {
        if(isEmpty()) throw new NoSuchElementException();
        if (output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

}
