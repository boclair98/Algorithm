import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m, s;
    static int[] arr = new int[55];
    static int[][] dp = new int[55][1050];
    static int recur(int idx, int sound){
        if(sound < 0 || sound > s) return -1000000000;
        if(idx == n) return sound;
        if(dp[idx][sound] !=-1) return dp[idx][sound];
        int a = -1000000000;
        if(sound - arr[idx] >= 0){
            a = recur(idx+1, sound-arr[idx]);
        }
        int b =-1000000000;
        if(sound + arr[idx] <=s){
            b = recur(idx+1, sound+arr[idx]);
        }
        return dp[idx][sound] = Math.max(a,b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 55; i++){
            Arrays.fill(dp[i], -1);
        }
        int res = recur(0,m);
        if(res < 0){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }

    }
}

