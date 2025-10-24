import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;;
        DFS(1,0);
        System.out.println(answer);

    }

    private static void DFS(int index, int count) {
        if(count >=1){
            calc();
        }
        for(int i = index; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(i+1,count+1);
                visited[i] = false;
            }
        }
    }
    static void calc(){
        int start = 0, link = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(visited[i] && visited[j]){
                    start+=map[i][j] + map[j][i];

                }
                else if(!visited[i] && !visited[j]){
                    link+=map[i][j] + map[j][i];
                }
            }
        }
        answer = Math.min(answer,(Math.abs(start-link)));
    }
}
