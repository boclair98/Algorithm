import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int[] day = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            day[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 1;
        int start = 0 ;
        int cnt = 1;
        int total = day[0];
        int max_val = 0;
        while(idx<n){
            total+=day[idx];
            if(idx - start == x-1){
                if(total > max_val) {
                    max_val = total;
                    cnt = 1;
                }else if(total == max_val){
                    cnt++;
                }
                total-=day[start];
                start++;
            }
            idx++;
        }
        if(max_val == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max_val);
        System.out.println(cnt);


    }


}
