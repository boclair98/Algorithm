import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean sosu(long idx){
        if(idx <=1) return false;
        for(long i = 2; i*i<=idx; i++){
            if(idx % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long max_val = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            while(num<=max_val){
                if(sosu(num)){
                    System.out.println(num);
                    break;
                }
                num++;
            }
        }
    }
}
