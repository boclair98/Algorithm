import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, k, cnt;
    static int[][] dp = new int[205][205];
    static int recur(int total, int count){
        if(total > n) return 0;
        if(dp[total][count] != -1)return dp[total][count];
        if(count == k){
            if(total == n){
                return 1;
            }
            return 0;
        }
        int a = 0;
        for(int i = 0; i <= n; i++){
            if(total + i <=n){
                a  = (a+ recur(total+i,count+1)) % 1000000000 ;
            }
        }
        return dp[total][count] = a % 1000000000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 205; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0) % 1000000000);


    }
}

