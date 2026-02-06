import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[1010];
    static int[][][] dp = new int[1010][1010][5];
    static int recur(int idx, int now,int prev){
        if(idx == n) return 0;
        if(dp[idx][now][prev] != -1) return dp[idx][now][prev];
        int ans = recur(idx+1, now, prev);
        if(prev == 0){
            ans = Math.max(ans,recur(idx+1,arr[idx],1)+1);
        }
        if(prev == 1){
            if(arr[idx] > now){
                ans = Math.max(ans,recur(idx+1,arr[idx],1)+1);
            }
            if(arr[idx] < now){
                ans = Math.max(ans,recur(idx+1,arr[idx],2)+1);
            }
        }
        if(prev == 2){
            if(arr[idx] < now){
                ans = Math.max(ans,recur(idx+1,arr[idx],2)+1);
            }
        }
        return dp[idx][now][prev] = ans;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i< 1010; i++){
            for(int j = 0 ; j< 1010; j++){
                for(int k = 0 ; k< 5; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(recur(0,0,0));

    }

}
