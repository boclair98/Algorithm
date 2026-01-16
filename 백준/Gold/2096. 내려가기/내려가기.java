import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[100050][3];
    static int[][] dp = new int[100050][3];
    static int[][] dp2 = new int[100050][3];
    static int recurMin(int idx, int num, int total){
        if(idx == n) return 0;
        if(dp2[idx][num] != -1) return dp2[idx][num];
        int ans = Integer.MAX_VALUE;
        if(num == 0){
            ans = Math.min(ans,recurMin(idx+1,0,total+arr[idx][0]));
            ans = Math.min(ans,recurMin(idx+1,1,total+arr[idx][1]));
        }
        if(num == 1){
            ans = Math.min(ans,recurMin(idx+1,0,total+arr[idx][0]));
            ans = Math.min(ans,recurMin(idx+1,1,total+arr[idx][1]));
            ans = Math.min(ans,recurMin(idx+1,2,total+arr[idx][2]));
        }
        if(num == 2){
            ans = Math.min(ans,recurMin(idx+1,1,total+arr[idx][1]));
            ans = Math.min(ans,recurMin(idx+1,2,total+arr[idx][2]));
        }
        return dp2[idx][num] = ans + arr[idx][num];
    }
    static int recurMax(int idx, int num, int total){
        if(idx == n) return 0;
        if(dp[idx][num] != -1) return dp[idx][num];
        int ans = 0;
        if(num == 0){
            ans = Math.max(ans,recurMax(idx+1,0,total+arr[idx][0]));
            ans = Math.max(ans,recurMax(idx+1,1,total+arr[idx][1]));
        }
        if(num == 1){
            ans = Math.max(ans,recurMax(idx+1,0,total+arr[idx][0]));
            ans = Math.max(ans,recurMax(idx+1,1,total+arr[idx][1]));
            ans = Math.max(ans,recurMax(idx+1,2,total+arr[idx][2]));
        }
        if(num == 2){
            ans = Math.max(ans,recurMax(idx+1,1,total+arr[idx][1]));
            ans = Math.max(ans,recurMax(idx+1,2,total+arr[idx][2]));
        }
        return dp[idx][num] = ans + arr[idx][num];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        for(int i = 0; i<100050; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(dp2[i], -1);
        }
        int max_val = 0;
        int min_val = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            max_val = Math.max(max_val,recurMax(0,i,0));
        }
        for(int i = 0; i < 3; i++) {
            min_val = Math.min(min_val,recurMin(0,i,0));
        }
        System.out.println(max_val+" "+min_val);

    }
}
