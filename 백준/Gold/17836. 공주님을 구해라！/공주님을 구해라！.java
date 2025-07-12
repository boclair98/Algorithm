import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static int n, m, t,sword;
    static boolean[][][]visited;
    static int[][]maps;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int Now = BFS(0, 0);
        if(Now<=t){
            System.out.println(Now);
        }else{
            System.out.println("Fail");
        }

    }
    private static int BFS(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        int cnt =0;
        q.add(new int[]{sx,sy,sword,cnt});
        visited[sx][sy][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int sword =cur[2];
            int count = cur[3];
            if(x == n-1 && y == m-1){
                return count;
            }
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx>=n || ny>=m) continue;
                if(sword == 0){
                    if(!visited[nx][ny][0] && maps[nx][ny] == 0){
                        q.offer(new int[]{nx,ny,sword,count+1});
                        visited[nx][ny][0] = true;
                    }else if(!visited[nx][ny][0] && maps[nx][ny] == 2){
                        q.offer(new int[]{nx,ny,1,count+1});
                        visited[nx][ny][0] = true;
                    }
                }else{
                    if(!visited[nx][ny][1]){
                        q.offer(new int[]{nx,ny,sword,count+1});
                        visited[nx][ny][1] = true;
                    }
                }

            }
        }
        return t+1;
    }
}
