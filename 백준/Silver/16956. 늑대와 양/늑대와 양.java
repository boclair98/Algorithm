import java.io.*;
import java.util.*;

public class Main {
    static int r,c;
    static char[][] map;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for(int i = 0; i < r; i++){
            String word = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = word.charAt(j);
                if(map[i][j] == 'W') {
                    q.add(new int[]{i,j});
                }
            }
        }
        BFS();
        if(!flag){
            System.out.println(0);
        }else{
            System.out.println(1);
            for(int i = 0; i<r; i++){
                for(int j = 0; j<c; j++){
                    System.out.print(map[i][j]+"");
                }
                System.out.println();
            }
        }
    }

    private static void BFS() {
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                if(map[nx][ny] == '.'){
                    map[nx][ny] = 'D';
                }
                if(map[nx][ny] =='S'){
                    flag = false;
                    break;
                }
            }
        }
    }
}
