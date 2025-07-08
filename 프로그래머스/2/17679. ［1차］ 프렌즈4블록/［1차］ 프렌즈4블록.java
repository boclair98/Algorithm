import java.util.*;
class Solution {
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};
    static Queue<int[]> queue = new ArrayDeque<>();
    
    public int solution(int n, int m, String[] board) {
        int answer = 0;
        //2차원 배열로 구분
        String[][] maps = new String[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                maps[i][j] = board[i].charAt(j)+"";
            }
        }
        
        //2*2 시작점을 찾고 queue에 추가
        while(true){
            queue.clear();
            boolean same = false;
            for(int i = 0; i<n-1; i++){
                for(int j = 0; j<m-1; j++){
                    if(maps[i][j].equals(maps[i+1][j]) && !maps[i][j].equals(" ")){
                        if(maps[i][j].equals(maps[i][j+1])){
                            if(maps[i][j].equals(maps[i+1][j+1])){
                                queue.add(new int[]{i,j});
                                same = true;
                            // System.out.println(i+" "+j);
                        }
                    }
                }
            }
        }
        
        //BFS 시작 
        while (!queue.isEmpty()){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                maps[x][y] =" ";
                for(int i = 0; i<3; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >=n || ny >=m) continue;
                    maps[nx][ny] = " ";
                }
            }
            if(!same){
                break;
            }else{
                change(n,m,maps);
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(maps[i][j].equals(" ")){
                    answer++;
                }
                System.out.print(maps[i][j]+"");
            }
            System.out.println();
        }
        return answer;
    }
    
    private static void change(int n, int m, String[][] maps){
    for (int j = 0; j < m; j++) { // 열 기준
        for (int i = n - 1; i >= 0; i--) { // 아래에서 위로
            if (maps[i][j].equals(" ")) {
                for (int k = i - 1; k >= 0; k--) {
                    if (!maps[k][j].equals(" ")) {
                        maps[i][j] = maps[k][j];
                        maps[k][j] = " ";
                        break;
                    }
                }
            }
        }
    }
}
}