import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, k;
    static int[] coin = new int[110];
    static int[][] dp = new int[110][11000];
    static int count = 0;
    static int recur(int idx, int total){
        if(total == k) return 1;
        if(total > k || idx == n) return 0;
        if(dp[idx][total] != -1 ) return dp[idx][total];
        int a = 0;
        for(int i = idx; i < n; i++){
            a+=recur(i,total+coin[i]);
        }
        return dp[idx][total] = a;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i<110; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));
    }
}

