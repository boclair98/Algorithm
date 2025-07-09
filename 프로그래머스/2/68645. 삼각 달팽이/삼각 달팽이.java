import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1};     
    static int[] dy = {0, 1, -1};
    
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] maps = new int[n][n];
        int count = 1;
        int x = 0;
        int y = 0;
        int dir = 0;
        int max = n * (n + 1) / 2;

        while (count <= max) {
            maps[x][y] = count++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || maps[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                if(maps[i][j] > 0){
                    answer.add(maps[i][j]);
                }
            }
        }

        return answer;
    }
}
