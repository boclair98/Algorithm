import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr = new int[2020];
    static int[][] dp = new int[2020][2020];
    static int recur(int start, int end){
        if(start >= end) return 1;
        if(dp[start][end] != -1) return dp[start][end];
        if(arr[start] == arr[end]){
            return dp[start][end] = recur(start+1,end-1);
        }
        return dp[start][end] = 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 2020; i++) {
            Arrays.fill(dp[i], -1);
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(recur(a-1,b-1)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
