import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] visited2;
    static int min_val = Integer.MAX_VALUE;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static List<int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }
        visited2 = new boolean[virus.size()];
        dfs(0,0);
        if(min_val == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min_val);
        }


    }

    private static void dfs(int idx, int start) {
        if(idx == m){
            bfs();
            return;
        }
        for(int i = start; i<virus.size(); i++){
            if(!visited2[i]){
                visited2[i] = true;
                dfs(idx+1,i+1);
                visited2[i] = false;
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] copy = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(copy[i],0);
        }
        visited = new boolean[n][n];
        for(int i = 0 ; i<virus.size(); i++){
            if(visited2[i]){
                q.add(new int[]{virus.get(i)[0],virus.get(i)[1],0});
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            visited[x][y] = true;
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(map[nx][ny] == 1) continue;
                if(map[nx][ny] ==0  && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    copy[nx][ny] = dist+1;
                    q.add(new int[]{nx,ny,dist+1});
                }
                if(map[nx][ny] == 2 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,dist+1});
                }
            }
        }
        int total = 0;
        boolean check = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
//                System.out.print(copy[i][j]+" ");
                if(copy[i][j] == 0 && map[i][j] == 0){
                    check = false;
                }
                total = Math.max(total,copy[i][j]);
            }
//            System.out.println();
        }
//        System.out.println("________________________");
        if(check){
            min_val = Math.min(min_val,total);
        }




    }


}
