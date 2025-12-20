import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] t = new int[100];
    static int[] p = new int[100];
    static int[][] dp = new int[100][105];
    static int recur(int idx, int hp){
        if(idx >= n) return 0;
        if(dp[idx][hp] != -1) return dp[idx][hp];
        int a = recur(idx+1, hp);
        int b = 0;
        if(hp - t[idx] > 0){
            b = p[idx] + recur(idx+1, hp-t[idx]);
        }
        return dp[idx][hp] = Math.max(a,b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            t[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<100; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0,100));
    }
}

