package leetcode.priorityQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class RevealDeck {
    public static void main(String[] args) {
        int[] deck = {17,13,11,7,5,3,2};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }
    static int[] deckRevealedIncreasing(int[] deck) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int i : deck){
            queue.offer(i);
        }
        int[] result = new int[deck.length];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(queue.poll());
        while(!queue.isEmpty()){
            list.addFirst(list.removeLast());
            list.addFirst(queue.poll());
        }
        int index  = 0 ;
        for(int i : list){
            result[index] = i;
            index++;
        }
        return result;
    }
}


