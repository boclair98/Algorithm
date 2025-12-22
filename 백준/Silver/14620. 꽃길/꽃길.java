import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] map = new int[15][15];
    static boolean[][] visited = new boolean[15][15];
    static int[] dx = {1,0,-1,0,0};
    static int[] dy = {0,1,0,-1,0};
    static int min_val = Integer.MAX_VALUE;
    static boolean initVisited2(int x, int y){
        for(int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!setRange(nx,ny)){
                visited[nx][ny] = false;
            }
        }
        return true;
    }
    static boolean setRange(int x, int y){
        return x < 0 || x>=n  || y < 0 || y>=n;
    }
    static boolean initVisited(int x, int y){
        for(int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!setRange(nx,ny)){
                if(visited[nx][ny])return false;
            }
        }
        return true;
    }
    static int setCoin(int x, int y){
        int num = 0;
        for(int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!setRange(nx,ny)){
                num+=map[nx][ny];
                visited[nx][ny] = true;
            }
        }
        return num;
    }
    static void backtrack(int count, int total) {
        if(count == 3){
            min_val = Math.min(min_val,total);
            return;
        }

        for(int i = 1; i<n-1; i++){
            for(int j = 1; j<n-1; j++){
                if(initVisited(i,j)){
                    int coins = setCoin(i,j);
                    backtrack(count+1, total+coins);
                    initVisited2(i,j);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtrack(0,0);
        System.out.println(min_val);
    }
}

