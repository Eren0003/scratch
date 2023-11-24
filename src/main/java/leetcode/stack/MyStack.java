package leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStack {
static Queue<Integer> queue = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        List<Integer> list = new ArrayList<>();
        queue.add(x);
        while(!queue.isEmpty()){
            if(queue.size() != 1){
                list.add(queue.poll());
            }else{
                break;
            }
        }
        queue.addAll(list);
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
