import java.util.*;
class Solution {
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String word = storage[i];
            for(int j = 0; j<m; j++){
                map[i][j] = word.charAt(j);
                // System.out.print(map[i][j]+" ");
            }
            // System.out.println();
        }
        for(int i = 0; i<requests.length; i++){
            String alpha = requests[i];
            if(alpha.length() == 1){
                bfs(alpha);
            }else{
                crain(alpha);
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] != '.') answer++;
            }
            
        }
        return answer;
    }
    static void bfs(String alpha){
        char a = alpha.charAt(0);
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == a){
                    if(i == 0 || i == n-1 || j == 0 || j == m-1){
                        v[i][j] = true;
                        map[i][j] = '.';
                    }
                    
                }else if(map[i][j] =='.' && (i == 0 || i == n-1 || j == 0 || j == m-1)){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            visited[x][y] = true;
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(map[nx][ny] == '.'&& !v[nx][ny]){
                    q.add(new int[]{nx,ny});
                    v[nx][ny] = true;
                }
                if(map[nx][ny] == a && !v[nx][ny]){
                    v[nx][ny] = true;
                    map[nx][ny] = '.';
                    visited[nx][ny] = true;
                }
            }
            
        }
    }
    static void crain(String alpha){
        char a = alpha.charAt(0);
        for(int j = 0; j<n; j++){
            for(int k = 0; k<m; k++){
                if(map[j][k] == a){
                    visited[j][k] = false;
                    map[j][k] = '.';
                }
            }
        }
    }
}