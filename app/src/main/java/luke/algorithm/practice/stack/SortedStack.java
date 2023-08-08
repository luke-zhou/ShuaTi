package luke.algorithm.practice.stack;

import java.util.Stack;

public class SortedStack extends Stack<Integer>{
    Stack<Integer> temp = new Stack<>();

    public void push(int v){
        if(isEmpty()){
            super.push(v);
            return;
        }
        int min = super.peek();
        while(v > min) {
            temp.push(super.pop());
            if(super.isEmpty()){
                break;
            }
            min = super.peek();
        }
        super.push(v);
        while(!temp.isEmpty()){
            super.push(temp.pop());
        }
    }
}
