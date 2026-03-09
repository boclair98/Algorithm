import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int cnt = Integer.MAX_VALUE;
    static int cnt2 = 0;
    static StringTokenizer st;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[] visited;
    static boolean[][] visited2;
    static List<int[]> list = new ArrayList<>();
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new int[]{i,j});
            }
        }
        visited = new boolean[virus.size()];

        //백트래킹으로 좌표 생성 후 bfs 진행
        dfs(0);
        if(cnt == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(cnt);
        }
    }
    static void dfs(int idx){
        if(list.size() == m){
            Deque<int[]> dq = new ArrayDeque<>();
            visited2 = new boolean[n][n];
            int[][] maps = new int[n][n];
            for (int[] ints : list) {
                dq.add(new int[]{ints[0],ints[1]});
                visited2[ints[0]][ints[1]] = true;
//                maps[ints[0]][ints[1]] = 1;
            }

            while(!dq.isEmpty()){
                int[] cur = dq.poll();
                int x = cur[0];
                int y = cur[1];
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                    if(!visited2[nx][ny] && map[nx][ny] != 1){
                        visited2[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1;
                        dq.add(new int[]{nx,ny});
                    }
                }
            }
            if(check()){
                cnt2 = 0;
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(map[i][j] != 1){
                            cnt2 = Math.max(cnt2,maps[i][j]);
                        }
                    }
                }
                cnt = Math.min(cnt,cnt2);
            }
            return;
        }
        for(int i = idx; i < virus.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(virus.get(i));
                dfs(i+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    static boolean check(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited2[i][j] && map[i][j]!=1) return false;
            }
        }
        return true;
    }

}

