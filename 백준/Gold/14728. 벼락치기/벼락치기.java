import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, t;
    static int[][] arr = new int[110][2];
    static int[][] dp = new int[110][100000];
    static int recur(int idx,int total){
        if(total > t) return -1000000000;
        if(idx == n) return 0;
        if(dp[idx][total] != -1) return dp[idx][total];
        int score = 0;
        score = Math.max(score,recur(idx+1,total+arr[idx][0]) + arr[idx][1]);
        score = Math.max(score,recur(idx+1,total));
        return dp[idx][total] = score;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 110; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0));
    }
}