import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int c,n, m,time ;
    static char[][][] maps;
    static boolean[][][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int floors = -1;
            int startX = -1;
            int startY = -1;
            if(c == 0 && n == 0 && m == 0) break;
            maps = new char[c][n][m];
            visited = new boolean[c][n][m];
            for(int i = 0; i<c; i++){
                for(int j = 0; j<n; j++){
                    String word = br.readLine();
                    for(int k = 0; k<m; k++){
                        maps[i][j][k] = word.charAt(k);
                        if(maps[i][j][k] == 'S'){
                            floors = i;
                            startX = j;
                            startY = k;
                        }
                    }
                }
                br.readLine();
            }
            int num = bfs(floors,startX,startY);
//            System.out.println(num);
            if(num !=-1){
                System.out.println("Escaped in "+num+" minute(s).");
            }else{
                System.out.println("Trapped!");
            }
        }




    }

    private static int bfs(int floors, int startX, int startY) {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{floors,startX,startY,0});
        visited[floors][startX][startY] = true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int floor = cur[0];
            int x = cur[1];
            int y = cur[2];
            int count = cur[3];
            if(maps[floor][x][y] == 'E'){
                return count;
            }
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if((maps[floor][nx][ny] == '.'||maps[floor][nx][ny] =='E') && !visited[floor][nx][ny]){
                    visited[floor][nx][ny] = true;
                    q.add(new int[]{floor,nx,ny,count+1});
                }
            }
            if(floor - 1 >=0 && !visited[floor-1][x][y] && (maps[floor-1][x][y] =='.'||maps[floor-1][x][y] =='E')){
                visited[floor-1][x][y] = true;
                q.add(new int[]{floor-1,x,y,count+1});
            }
            if(floor+1<c && !visited[floor+1][x][y] && (maps[floor+1][x][y] =='.'||maps[floor+1][x][y] =='E')){
                visited[floor+1][x][y] = true;
                q.add(new int[]{floor+1,x,y,count+1});
            }
        }
        return -1;

    }
}
