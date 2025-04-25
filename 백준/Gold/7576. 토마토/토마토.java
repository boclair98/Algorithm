import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n,m,cnt,zero;
    static int[][] map;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visited;
    static StringTokenizer st;
    static boolean check;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        //BFS
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //BFS 시작
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 1){
                    q.offer(new int[]{i,j});
                }
                if(map[i][j] == 0){
                    zero++;
                }
            }
        }
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }
        check = false;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 0){
                    check = true;
                    break;
                }else{
                    cnt = Math.max(cnt,map[i][j]);
                }
            }
            if(check){
                break;
            }

        }
        if(zero == 0){
            System.out.println(0);
        }else if(check){
            System.out.println(-1);
        }else{
            System.out.println(cnt-1);
        }


    }





}

