import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,l,r;
    static int[][] map;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tot_count = 0;
        while(true){
            visited = new boolean[n][n];
            boolean move = false;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(!visited[i][j]){
                        Queue<int[]> queue = bfs(i,j);
                        if(queue.size() > 1){
                            move = true;
                        }
                        int sum = 0;
                        for (int[] ints : queue) {
                            sum+=map[ints[0]][ints[1]];
                        }
                        int total = sum / queue.size();
                        for(int[] ints : queue){
                            map[ints[0]][ints[1]] = total;
                        }
                    }
                }
            }
            if(move){
                tot_count++;
            }else{
                break;
            }
        }
        System.out.println(tot_count);

    }


    public static Queue<int[]> bfs(int sx,int sy){
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> queue = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        queue.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                int total = Math.abs(map[x][y] - map[nx][ny]);
                if(!visited[nx][ny] && total>=l && total<=r){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return queue;
    }
}

