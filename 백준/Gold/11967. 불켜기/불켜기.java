import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static boolean[][] light, visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static List<int[]>[][] switches;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        light = new boolean[n+1][n+1];
        visited = new boolean[n+1][n+1];
        switches = new ArrayList[n+1][n+1];

        for(int i = 1; i<=n; i++){
            for(int j =1; j<=n; j++){
                switches[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            switches[a][b].add(new int[]{c,d});
        }

        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,1});
        visited[1][1] = true;
        light[1][1] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 스위치 켜기
            for(int[] li : switches[x][y]){
                int nx = li[0];
                int ny = li[1];
                if(!light[nx][ny]){
                    light[nx][ny] = true;
                    cnt++;
                    // 새로 켜진 방이 인접 방문된 방 있으면 바로 큐에 추가
                    for(int i = 0; i<4; i++){
                        int x1 = nx + dx[i];
                        int y1 = ny + dy[i];
                        if(x1<1 || x1>n || y1<1 || y1>n) continue;
                        if(visited[x1][y1]){
                            visited[nx][ny] = true;
                            q.add(new int[]{nx,ny});

                        }
                    }
                }
            }

            // 상하좌우 이동
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<1 || nx > n || ny<1 || ny>n) continue;
                if(!visited[nx][ny] && light[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }
}
