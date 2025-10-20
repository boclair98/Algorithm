import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int v,e;
    static int[][] dist;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[v+1][v+1];
        for(int i =1; i<=v; i++){
            Arrays.fill(dist[i],INF);
        }
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for(int k = 1; k<=v; k++){
            for(int i = 1; i<=v; i++){
                for(int j = 1; j<=v; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int answer = INF;
        for(int i = 1; i<=v; i++){
            for(int j = 1; j<=v; j++){
                if(i == j) continue;
                if(dist[i][j]!= INF && dist[j][i] != INF){
                    answer = Math.min(answer,dist[i][j]+dist[j][i]);
                }
            }
        }
        if(answer == INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
}
