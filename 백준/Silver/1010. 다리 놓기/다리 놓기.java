import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static int[][] dp ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[30][30];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(factorial(b,a));
        }
    }
    static int factorial(int a, int b){
        if(dp[a][b] > 0){
            return dp[a][b];
        }
        if(a == b || b == 0){
            return dp[a][b] = 1;
        }
        return dp[a][b] = factorial(a-1,b-1) + factorial(a-1,b);
    }

}