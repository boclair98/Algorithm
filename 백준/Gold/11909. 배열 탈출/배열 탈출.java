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
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(dist[n-1][n-1]);
    }
    static void bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[2],o2[2]);
        });
        pq.add(new int[]{0,0,0});
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int money = cur[2];
            for(int i = 0; i < 2; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nm = money;
                if(nx < 0 || nx>=n || ny < 0 || ny>=n) continue;
                if(map[nx][ny] >= map[x][y]){
                    nm+=(map[nx][ny]-map[x][y]+1);
                }
                if(nm >= dist[nx][ny]) continue;
                dist[nx][ny] = nm;
                pq.add(new int[]{nx,ny,nm});
            }
        }
    }
}