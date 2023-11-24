import java.util.ArrayList;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        System.out.println(luhnsAlgo("79927398713"));
    }
    static String luhnsAlgo(String cardNo){
        String result = "";
        for(int i = 0 ; i < cardNo.length() ; i++){
            if(i%2 != 0){
                int num = (cardNo.charAt(i)-'0')*2;
                if(num > 9){
                    int rem = num%10;
                    num = num/10 + rem;
                }
                result += num;
            }else{
                result += cardNo.charAt(i);
            }
        }
        return result;
    }
}
