import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int score1 = 100;
        int score2 = 100;

        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a < b){
                score1-=b;
            }else if(a > b){
                score2-=a;
            }
        }
        System.out.println(score1);
        System.out.println(score2);
    }

}
