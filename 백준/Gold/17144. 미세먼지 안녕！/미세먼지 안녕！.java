import java.io.*;
import java.util.*;

public class Main {
    static int n,m,t;
    static int[][] map;

    static int up_x,up_y,down_x,down_y;
    static StringTokenizer st;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        up_x = -1;
        up_y = -1;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == -1 && up_x == -1){
                    up_x = i;
                    up_y = j;
                }else if(map[i][j] == -1 && up_x > -1){
                    down_x = i;
                    down_y = j;
                }

            }
        }
//        미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
//        (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
//                인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
//        확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
//        (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.
        while(t-- > 0){
            bfs();
            air_moving();
        }
        int total = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] > 0 ){
                    total+=map[i][j];
                }
            }
        }
        System.out.println(total);
    }
    static void bfs(){
        int[][] copy = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] > 0){
                    int cnt = 0 ;
                    for(int k = 0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
                        if(map[nx][ny] == -1) continue;
                        copy[nx][ny] += map[i][j] / 5;
                        cnt++;
                    }
                    copy[i][j]+=map[i][j] - ((map[i][j] / 5) * cnt);
                }
            }
        }
        copy[up_x][up_y] = -1;
        copy[down_x][down_y] = -1;
        map = copy;
    }

    static void air_moving(){
        for(int i = up_x-1; i>=1; i--){
            map[i][0] = map[i-1][0];
        }
        for(int i = 0; i<m-1; i++){
            map[0][i] = map[0][i+1];
        }
        for(int i = 0; i<up_x; i++){
            map[i][m-1] = map[i+1][m-1];
        }
        for(int i = m-1; i>=2; i--){
            map[up_x][i] = map[up_x][i-1];
        }
        map[up_x][1] = 0;

        for(int i = down_x+1; i<n-1; i++){
            map[i][0] = map[i+1][0];
        }

        for(int i = 0; i<m-1; i++){
            map[n-1][i] = map[n-1][i+1];
        }

        for(int i = n-1; i>down_x; i--){
            map[i][m-1] = map[i-1][m-1];
        }
        for(int i = m-1; i>=2; i--){
            map[down_x][i] = map[down_x][i-1];
        }
        map[down_x][1] = 0;
    }

}
