package leetcode.Dynamic.memorization;

import java.awt.desktop.AppReopenedEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(frogGame(stones));

    }
    static boolean frogGame(int[] stones){
        return dfs(stones, 0,0);
    }
    static boolean dfs(int[] stones,int prevUnit ,int index){
        if(index == stones.length-1){
            return true;
        }
        for(int i = index+1; i < stones.length ; i++){
            if(stones[i] == stones[index]+prevUnit || stones[i] == stones[index]+prevUnit-1 || stones[i] == stones[index]+prevUnit+1){
                if(dfs(stones,Math.abs(stones[index]-stones[i]),i)){
                    return true;
                }
            }
        }
        return false;
    }

}
