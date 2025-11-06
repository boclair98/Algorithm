import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = -1;
        char[][] map = new char[3][3];
        for(int i = 0; i<3; i++){
            String word = board[i];
            for(int j = 0; j<3; j++){
                map[i][j] = word.charAt(j);
            }
        }
        int x = 0, o = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(map[i][j] == 'X'){
                    x++;
                }
                if(map[i][j] == 'O'){
                    o++;
                }
            }
        }
        if(x > o || o - x > 1) return 0;
        boolean x_c = check(map,'X');
        boolean o_c = check(map,'O');
        if(x_c && o_c) return 0;
        if(x_c && o > x) return 0;
        if(o_c && o!=x+1) return 0;
        return 1;
    
    }
     static boolean check(char[][] map, char a) {
        // 대각선 검사
        if (map[0][0] == a && map[1][1] == a && map[2][2] == a) return true;
        if (map[0][2] == a && map[1][1] == a && map[2][0] == a) return true;
        // 가로 검사
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == a && map[i][1] == a && map[i][2] == a) return true;
        }
        // 세로 검사
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == a && map[1][i] == a && map[2][i] == a) return true;
        }
        return false;
    }
    
    
}