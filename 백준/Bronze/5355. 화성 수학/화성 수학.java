import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            String[] cal = br.readLine().split(" ");
            double num = 0.0;
            for(int j =0 ; j<cal.length; j++){
                if(cal[j].equals("@")){
                    num*=3;
                }else if(cal[j].equals("%")){
                    num+=5;
                }else if(cal[j].equals("#")){
                    num-=7;
                }else{
                    num+=Double.parseDouble(cal[j]);
                }
            }
            System.out.printf("%.2f\n", num);
        }
    }
}
