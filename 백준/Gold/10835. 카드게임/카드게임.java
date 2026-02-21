import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] arr1 = new int[2020];
    static int[] arr2 = new int[2020];
    static int[][] dp = new int[2020][2020];
    static int recur(int idx, int idx2){
        if(idx == n || idx2 == n) return 0;
        if(dp[idx][idx2] != -1) return dp[idx][idx2];
        int ans = 0;
        if(arr1[idx]<=arr2[idx2]){
            ans = Math.max(ans,recur(idx+1,idx2));
            ans = Math.max(ans,recur(idx+1,idx2+1));
        }
        if(arr1[idx] > arr2[idx2]){
            ans = Math.max(ans,recur(idx,idx2+1)+arr2[idx2]);
        }
        return dp[idx][idx2] = ans;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 2020; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));

    }
}
