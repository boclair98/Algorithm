import java.util.*;
class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int n,m;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return bfs(0,0,maps);
    }
    public static int bfs(int sx, int sy,int[][] maps){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx,sy,0});
        visited[sx][sy] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if(x == n-1 && y == m-1) return count+1;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=n || ny < 0 || ny>=m) continue;
                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dq.add(new int[]{nx,ny,count+1});
                    
                }
            }
        }
        return -1;
    }
    
}