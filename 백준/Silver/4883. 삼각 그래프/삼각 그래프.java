import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static long[][] dp;
    static int[] dx ={0,1,1,0,1};
    static int[] dy ={0,0,1,1,-1};
    static final long INF = 1_000_000_000L;
    static long recur(int x, int y){
        if(x < 0 || x>=n || y < 0 || y>=3 ) return INF;
        if(x == n-1 && y == 1) return arr[x][y];
        if(dp[x][y] !=-1) return dp[x][y];
        if(x == n-1 && y !=1){
            if(y == 0){
                return dp[x][y] = recur(x,y+1) + arr[x][y];
            }
            return INF;
        }
        long answer = recur(x,y+1);
        answer = Math.min(answer,recur(x+1,y-1));
        answer = Math.min(answer,recur(x+1,y));
        answer = Math.min(answer,recur(x+1,y+1));

        return dp[x][y] = answer + arr[x][y];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
        int tc = 1;
        while(true){
            String line = br.readLine();
            if (line == null || line.equals("0")) break;
            n = Integer.parseInt(line);
            arr =  new int[100050][3];
            dp = new long[100050][3];
            for(int i = 0; i<100050; i++){
                Arrays.fill(dp[i], -1);
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(tc+". "+recur(0,1));
            tc++;
        }

    }
}

