import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n , m, k;
    static int[] dist;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(graph[i],1000000);
            graph[i][i] = 0;
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;

        }
        k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<k; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j =1; j<=n; j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int[] score = new int[n+1];
        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int maxRound = 0;
            for (int f = 0; f < k; f++) {
                int friendCity = arr[f];
                int round = graph[friendCity][i] + graph[i][friendCity];
                if (round >= 1000000) {
                    maxRound = Integer.MAX_VALUE;
                    break;
                }
                maxRound = Math.max(maxRound, round);
            }
            score[i] = maxRound;
            best = Math.min(best, maxRound);
        }
        
        for (int i = 1; i <= n; i++) {
            if (score[i] == best) {
                System.out.print(i + " ");
            }
        }
    }

}