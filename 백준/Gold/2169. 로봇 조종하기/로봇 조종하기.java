import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][m];
        int[][] temp = new int[2][m];
        dp[0][0] = map[0][0];
        for(int i = 1; i<m; i++){
            dp[0][i]+=dp[0][i-1] + map[0][i];
        }

        for(int i = 1; i<n; i++){

            //왼쪽 - > 오른쪽

            temp[0][0] = dp[i-1][0] + map[i][0];
            for(int j = 1; j<m; j++){
                temp[0][j] = Math.max(temp[0][j-1],dp[i-1][j]) + map[i][j];
//                System.out.println(temp[0][j]);
            }

            temp[1][m-1] = dp[i-1][m-1] + map[i][m-1];
            for(int j = m-2; j>=0; j--){
                temp[1][j] = Math.max(temp[1][j+1],dp[i-1][j]) + map[i][j];
            }

            for(int j =0; j<m; j++){
                dp[i][j] = Math.max(temp[0][j],temp[1][j]);
            }

        }
        System.out.println(dp[n-1][m-1]);


    }
}

