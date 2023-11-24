package leetcode.greedy;

public class AddMinimumRungs {
    public static void main(String[] args) {
        System.out.println(addRungs(new int[]{1,3,6,10},2));
    }
    static int addRungs(int[] rungs, int dist) {
        int prev = 0 ;
        int result = 0 ;
        int i = 0 ;
        while(i < rungs.length){
            if(rungs[i]-prev <= dist){
                prev = rungs[i];
                i++;
            }else{
                int diff = rungs[i]-prev;
                if(diff%dist == 0){
                    result += diff/dist-1;
                    prev += (diff/dist-1)*dist;
                }else{
                    result += diff/dist;
                    prev += (diff/dist)*dist;
                }
            }
        }
        return result;
    }
}
