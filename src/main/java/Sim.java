import org.w3c.dom.ls.LSOutput;

public class Sim {
    public static void main(String[] args) {
        int n = 10;
        StringBuilder result = new StringBuilder();
        int count = n;int startStar = n-1;int endStar = n;
        for(int i = 0 ; i < n ; i++){
            if(i != n-1) {
                for (int j = 0; j < count; j++) {
                    if (j == startStar) {
                        result.append('*');
                        startStar--;
                    } else if (j == endStar) {
                        result.append('*');
                        endStar++;
                    } else {
                        result.append(' ');
                    }
                }
            }else{
                for(int j = 0 ; j < count ; j++){
                    result.append('*');
                }
            }
            count++;
            result.append('\n');
        }
        System.out.println(result);
    }
}
