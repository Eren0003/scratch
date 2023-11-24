package leetcode.mathgeometry;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(14));
    }
    static int integerBreak(int n){
        if(n == 3){
            return 3;
        }else if(n == 4){
            return 4;
        }else if(n == 2){
            return 2;
        }else{
            if(n%3 == 0){
                return (int) Math.pow(3,n/3);
            }else if(n%3 == 1){
                return (int) (Math.pow(3,(n/3)-1)*4);
            }else{
                return (int) (Math.pow(3,n/3)*2);
            }
        }
    }
}