import java.util.*;
class Solution {
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static boolean[][] visited;
    static int[] oil;
    static int n,m;
    static int max_val = 0;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oil = new int[m];
        
        for(int i = 0; i<m; i++){
            int total = 0;
            for(int j = 0; j<n; j++){
                if(!visited[j][i] && land[j][i] == 1){
                    bfs(j,i,land);
                }
            }
        }
        for(int i = 0; i<m; i++){
            max_val = Math.max(max_val,oil[i]);
        }
        return max_val;
    }
    
    private static void bfs(int sx,int sy,int[][] land){
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            set.add(y);
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(land[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    cnt++;
                }
            }
        }
        for(int index : set){
            oil[index]+=cnt;
        }
        
    }
}