import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[3];
    static int[][] hp = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };
    static int[][][] dp = new int[61][61][61];
    static int recur(int a, int b, int c){
        a = Math.max(0, a);
        b = Math.max(0, b);
        c = Math.max(0, c);
        if(a == 0 && b == 0 && c == 0) return 0;
        if(dp[a][b][c] != -1) return dp[a][b][c];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 6; i++){
            ans = Math.min(ans,recur(a-hp[i][0], b-hp[i][1], c-hp[i][2])+1);
        }
        return dp[a][b][c] = ans;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 61; i++){
            for(int j = 0; j < 61; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        System.out.println(recur(arr[0], arr[1], arr[2]));
    }
}