import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,k;
    static int[][] arr = new int[110][2];
    static int[][] dp = new int[110][100010];
    static int recur(int cur, int w){
        if(w > k) return -100000000;
        if(cur == n) return 0;
        if(dp[cur][w]!=-1) return dp[cur][w];
        int a = arr[cur][1] + recur(cur+1,w+arr[cur][0]);
        int b = recur(cur+1,w);
        return dp[cur][w] = Math.max(a,b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<110; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0));
    }
}