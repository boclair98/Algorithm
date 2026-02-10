import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static String line;
    static int[][] dp = new int[100][100];
    static int recur(int start, int end){
        if(start>=end) return 1;
        if(dp[start][end]!= -1) return dp[start][end];
        if(line.charAt(start) == line.charAt(end) && recur(start+1,end-1) == 1){
            return dp[start][end] = recur(start+1, end-1);
        }
        return dp[start][end] = 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        n = line.length();
        for(int i = 0; i < 100; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < n; i++){
            if(recur(i,n-1) == 1){
                System.out.println(n+i);
                break;
            }
        }

    }
}
