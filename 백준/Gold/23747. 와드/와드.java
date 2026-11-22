import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m,startX, startY;
    static boolean[][] visited;
    static char[][] map, answer;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        answer = new char[n][m];
        for(int i = 0; i < n; i++){
            String w = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = w.charAt(j);
                answer[i][j] ='#';
            }
        }
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        String line = br.readLine();
        for(int i = 0; i < line.length(); i++){
            char t = line.charAt(i);
            if(t == 'W'){
                if(!visited[startX][startY]){
                    bfs(startX,startY);
                }
            }else if(t == 'U'){
                startX-=1;
                if(!check(startX,startY)){
                    startX+=1;
                }
            }else if(t == 'D'){
                startX+=1;
                if(!check(startX,startY)){
                    startX-=1;
                }
            }else if(t == 'L'){
                startY-=1;
                if(!check(startX,startY)){
                    startY+=1;
                }
            }else if(t == 'R'){
                startY+=1;
                if(!check(startX,startY)){
                    startY-=1;
                }
            }
        }

        answer[startX][startY] = '.';
        for(int i = 0; i < 4; i++){
            int nx = startX + dx[i];
            int ny = startY + dy[i];
            if(check(nx,ny)){
                answer[nx][ny] ='.';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int startX, int startY) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{startX,startY});
        visited[startX][startY] = true;
        answer[startX][startY] = '.';
        char s = map[startX][startY];
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(!visited[nx][ny] && map[nx][ny] == s){
                    dq.add(new int[]{nx,ny});
                    answer[nx][ny] = '.';
                    visited[nx][ny] = true;
                }
            }
        }
    }
    private static boolean check(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        return true;
    }
}
