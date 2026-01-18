import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,k,max_cnt;
    static int[] arr;
    static int[][][] dp = new int[1010][40][3];
    static int recur(int idx, int turn, int now){
        if(idx == n) return 0;
        if(dp[idx][turn][now] != -1) return dp[idx][turn][now];
        int ap = -1;
        if(arr[idx] == now){
            ap = 1;
        }else{
            ap = 0;
        }
        int ans = recur(idx+1,turn,now) + ap;
        int move = 0;
        if(turn < k){
            int index = -1;
            if(now == 1){
                index = 2;
            }else if(now == 2){
                index = 1;
            }
            move = recur(idx+1,turn+1,index) + (arr[idx] == index ? 1: 0);
        }
        return dp[idx][turn][now] = Math.max(ans,move);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recur(0,0,1));
    }
}