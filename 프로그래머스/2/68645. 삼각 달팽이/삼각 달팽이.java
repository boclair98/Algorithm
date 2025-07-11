import java.util.*;

//2차원 배열 빈칸 채우기 
//아래 -> 오른쪽 -> 왼쪽위 대각선으로 채워줌.
//0이 아니라 숫자가 있을 시 방향 변경.

class Solution {
    //방향 설정하는 dx dy
    static int[] dx = {1, 0, -1};     
    static int[] dy = {0, 1, -1}; 
    
    public List<Integer> solution(int n) {
        //저장값 
        List<Integer> answer = new ArrayList<>();
        int[][] maps = new int[n][n];
        int count = 1;
        int x = 0;
        int y = 0;
        int dir = 0;
        
        //n값을 비교한후 어느 숫자까지 채워야 하는지 비교.
        int max = n * (n + 1) / 2;
        
        while (count <= max) {
            maps[x][y] = count++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //빈칸이 없거나 칸을 벗어 날시 방향 바꿔줌.
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || maps[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            //x,y값 재 정의
            x = nx;
            y = ny;
        }
        
        //숫자 다 집어 넣으면 answer에 정답 저장.
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
