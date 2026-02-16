import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,cnt,weight;
    static int[][] arr ;
    static int[][] dp = new int[25][10000];
    static int recur(int idx, int total){
        if(idx > cnt) return -Integer.MAX_VALUE;
        if(total > weight) return -Integer.MAX_VALUE;
        if(idx == cnt) return 0;
        if(dp[idx][total] != -1) return dp[idx][total];
        int ans = recur(idx+1,total);
        ans = Math.max(ans,recur(idx+1,total+arr[idx][0])+arr[idx][1]);
        return dp[idx][total] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            arr = new int[25][2];
            st  = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 25; i++){
                Arrays.fill(dp[i], -1);
            }
            for(int i=0;i<cnt;i++) {
                st  = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            System.out.println(recur(0,0));
        }

    }
}
