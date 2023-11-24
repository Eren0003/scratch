package leetcode.mathgeometry;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(uglyNumber(6));
    }
    static boolean uglyNumber(int n){
        if(n <= 0){
            return false;
        }
        int [] primes = {2,3,5};
        for(int i : primes){
            while(n%i == 0){
                i = n/i;
            }
        }
        if(n == 1) return true;
        return false;
    }
}
