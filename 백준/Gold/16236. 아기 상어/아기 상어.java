import java.io.*;
import java.util.*;

public class Main {
    static int n,sx,sy;
    static int[][] map;
    static int shark_size = 2;
    static boolean[][] visited;
    static StringTokenizer st;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static List<int[]> eats = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }
        int cnt = 0;
        int total = 0;
        while(true){
            eats.clear();
            bfs();
            if(eats.size() == 0){
                System.out.println(total);
                break;
            }
            Collections.sort(eats,(o1,o2) ->{
                if(o1[2] == o2[2]){
                    if(o1[0]== o2[0]){
                        return Integer.compare(o1[1],o2[1]);
                    }else{
                        return Integer.compare(o1[0],o2[0]);
                    }
                }
                return Integer.compare(o1[2],o2[2]);
            });
            int x = eats.get(0)[0];
            int y = eats.get(0)[1];
            int dist = eats.get(0)[2];
            total+=dist;
            map[x][y] = 0;
            cnt++;
            if(cnt == shark_size){
                cnt = 0;
                shark_size++;
            }
            sx = x;
            sy = y;

        }


    }
    private static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,0});
        visited = new boolean[n][n];
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(map[nx][ny] > shark_size) continue;
                if((map[nx][ny] == 0 || map[nx][ny] == shark_size) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,dist+1});
                }
                if(map[nx][ny] > 0 && map[nx][ny]<shark_size && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,dist+1});
                    eats.add(new int[]{nx,ny,dist+1});
                }
            }
        }
    }


}
