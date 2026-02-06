import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int d,p;
    static int[][] arr = new int[400][2];
    static int[][]dp = new int[400][100001];
    static int recur(int idx, int total){
        if(total == d) return Integer.MAX_VALUE;
        if(total > d) return 0;
        if(idx == p) return 0;
        if(dp[idx][total] != -1) return dp[idx][total];
        int res = Math.min(arr[idx][1],recur(idx+1, total + arr[idx][0]));
        int res1 = recur(idx+1,total);
        return dp[idx][total] = Math.max(res, res1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 400; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));


    }

}
