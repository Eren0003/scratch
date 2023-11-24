package leetcode.graph.bfs;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    static int ladderLength(String beginWord,String endWord,List<String> wordList){
        Set<String> list = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if(!list.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1 ;
        String abc = "abcdefghijklmnopqrstuvwxyz";
        while(!queue.isEmpty()){
            Queue<String> innerQueue = new LinkedList<>(queue);
            queue.removeAll(queue);
            while(!innerQueue.isEmpty()){
                String temp = innerQueue.poll();
                if(temp.equals(endWord)){
                    return level;
                }for(int i = 0 ; i < temp.length() ; i++){
                    for(int j = 0 ; j < abc.length() ; j++){
                        String newString = temp.substring(0,i)+abc.charAt(j)+temp.substring(i+1);
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
        return 0;
    }
}
