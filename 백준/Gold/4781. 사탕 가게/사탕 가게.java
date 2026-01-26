import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,c;
    static double m,p;
    static int[] arr;
    static int[] arr2;
    static long[] dp = new long[1000000];
    static long recur(int money){
        if(money < 0) return -1000000000;
        if(money == 0) return 0;
        if(dp[money] != -1) return dp[money];
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(money >= arr2[i]){
                ans = Math.max(ans,recur(money-arr2[i]) + arr[i]);
            }
        }
        return dp[money] = ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            arr = new int[5050];
            arr2 = new int[5050];
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
            if(n == 0 && m == 0) break;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
                arr2[i] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
            }
            Arrays.fill(dp,-1);
            System.out.println(recur((int)m));
        }
    }
}