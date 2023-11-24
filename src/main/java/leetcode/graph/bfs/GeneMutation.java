package leetcode.graph.bfs;

import java.util.*;

public class GeneMutation {
    public static void main(String[] args) {
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        System.out.println(minMutation(startGene,endGene,bank));
    }
    static int minMutation(String beginWord,String endWord ,String[] bank){
        Set<String> list = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        if(!list.contains(endWord)){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0 ;
        String acgt = "ACGT";
        while(!queue.isEmpty()){
            Queue<String> innerQueue = new LinkedList<>(queue);
            queue.removeAll(queue);
             while(!innerQueue.isEmpty()){
                 String temp = innerQueue.poll();
                 if(temp.equals(endWord)){
                     return level;
                 }for(int i = 0 ; i < temp.length() ; i++){
                     for(int j = 0 ; j < acgt.length() ; j++){
                         String newString = temp.substring(0,i)+acgt.charAt(j)+temp.substring(i+1);
                         if(newString.equals(temp) || visited.contains(newString)){
                             continue;
                         }
                         if(list.contains(newString)){
                             if(newString.equals(endWord)){
                                 return level+1;
                             }
                             queue.add(newString);
                             visited.add(newString);
                         }
                     }
                 }
             }
             level += 1;
        }
        return -1;
    }
}
