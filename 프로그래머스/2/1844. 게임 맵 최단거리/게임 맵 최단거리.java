import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int m = maps[0].length;
        int n = maps.length;
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        dist[0][0] = 1;
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx >=n || ny < 0 || ny>=m)continue;
                
                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                    
                }
            }
        }
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        if(dist[n-1][m-1] == 0){
            return -1;
        }
        return dist[n-1][m-1];
    }
}