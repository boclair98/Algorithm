import java.util.*;

class Solution {
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] map = new int[rows][columns];
        int count = 1;

        // 1부터 차례대로 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = count++;
            }
        }

        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int prev = map[x1][y1]; // 이전값 
            int min = Integer.MAX_VALUE;
                
            //왼쪽에서 오른쪽.
            for(int j = y1+1; j<=y2; j++){
                int temp = map[x1][j];
                map[x1][j] = prev;
                prev = temp;
                min = Math.min(min,prev);
            }
            
            //오른쪽 위에서 아래로 
            for(int j = x1+1; j<=x2; j++){
                int temp = map[j][y2];
                map[j][y2] = prev;
                prev = temp;
                min = Math.min(min,prev);
            }
            
            //오른쪽 대각선끝에서 왼쪽대각선 끝
            for(int j = y2-1; j>=y1; j--){
                int temp = map[x2][j];
                map[x2][j] = prev;
                prev = temp;
                min = Math.min(min,prev);
            }
            
            //왼쪽 대각선 끝에서 위로
            for(int j = x2-1; j>=x1; j--){
                int temp = map[j][y1];
                map[j][y1] = prev;
                prev = temp;
                min = Math.min(min,prev);
            }
            answer.add(min);
            
        }

        return answer;
    }
}
