import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int total = 0;
        for(int i = 0; i < n; i++ ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == b && a == c){
                total = Math.max(total,10000+a*1000);
            }else if(a == b && a!=c){
                total = Math.max(total,1000+a*100);
            }else if(a == c && a!=b){
                total = Math.max(total,1000+a*100);
            }else if(b == c && a!=b){
                total = Math.max(total,1000+b*100);
            }else{
                int max_val = 0;
                max_val = Math.max(a,Math.max(b,c));
                total = Math.max(total,max_val*100);
            }
        }
        System.out.println(total);
    }
}
