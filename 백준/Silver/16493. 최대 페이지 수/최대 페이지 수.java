import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,k;
    static int[][] arr = new int[250][2];
    static long[][] dp = new long[250][250];
    static long recur(int idx, int day){
        if(day == n) return 0;
        if(day > n) return -Integer.MAX_VALUE;
        if(idx == k) return 0;
        if(dp[idx][day]!= -1 ) return dp[idx][day];
        long ans = 0;
        ans = Math.max(ans,recur(idx+1,day+arr[idx][0])+arr[idx][1]);
        ans = Math.max(ans,recur(idx+1,day));
        return dp[idx][day] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 250; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0));

    }
}