import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    static int n;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int min_val = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(word.charAt(j)));
            }
        }

        bfs();
        System.out.println(min_val);

    }

    private static void bfs() {
        visited =new boolean[n][n];
        visited[0][0] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[2],o2[2]);
        });
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int wall = cur[2];
            if(x==n-1 && y == n-1){
                if(min_val > wall){
                    min_val = wall;
                    break;
                }
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=n || ny < 0 || ny>=n) continue;
                if(!visited[nx][ny] && map[nx][ny] == 0){
                    visited[nx][ny]= true;
                    pq.add(new int[]{nx,ny,wall+1});
                }
                if(!visited[nx][ny]&& map[nx][ny] == 1){
                    visited[nx][ny]= true;
                    pq.add(new int[]{nx,ny,wall});
                }
            }
        }

    }
}