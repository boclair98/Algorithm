import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,k;
    static int[][] map;
    static int s,x,y;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    list.add(new int[]{map[i][j], i, j, 0});
                }
            }
        }
        Collections.sort(list,((a,b) -> {
            return Integer.compare(a[0],b[0]);
        }));
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>(list);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int virusNum = cur[0];
            int x = cur[1];
            int y = cur[2];
            int time = cur[3];
            if(time == s) break;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(map[nx][ny] == 0){
                    map[nx][ny] = virusNum;
                    q.add(new int[]{virusNum,nx,ny,time+1});
                }
            }
        }
        System.out.println(map[x-1][y-1]);
    }
}