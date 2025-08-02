import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n , m;
    static int[][] map;
    static int[][] maps;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visited;
    static int groupId = 2;
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> mapCount = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        maps = new int[n][m];
        visited = new boolean[n][m];

        //map 설정
        for (int i = 0; i < n; i++) {
            String w = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(w.charAt(j) + "");
            }
        }

        //0의 거리 bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(map[i][j] == 1){
                    Set<Integer> set = new HashSet<>();
                    for(int k = 0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                        if(maps[nx][ny] > 0){
                            if(!set.contains(map[nx][ny])){
                                map[i][j]+=maps[nx][ny];
                                set.add(map[nx][ny]);
                            }
                        }
                    }
                    sb.append(map[i][j]%10).append("");
                }else{
                    sb.append(0).append("");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

        private static void bfs(int sx, int sy) {
            Set<int[]> set = new HashSet<>();
            Queue<int[]> q= new ArrayDeque<>();
            set.add(new int[]{sx,sy});
            q.offer(new int[]{sx,sy});
            visited[sx][sy] = true;
            int count = 1;
            while (!q.isEmpty()){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int i = 0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if(!visited[nx][ny] && map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        count++;
                        q.offer(new int[]{nx,ny});
                        set.add(new int[]{nx,ny});
                    }
                }
            }
            for (int[] ints : set) {
                int x = ints[0];
                int y = ints[1];
                maps[x][y] = count;
                map[x][y] = groupId;
            }
            groupId++;
//            System.out.println(count);

        }
}