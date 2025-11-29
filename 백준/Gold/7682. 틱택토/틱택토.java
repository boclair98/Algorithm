import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String word = br.readLine();
            int idx = 0;
            if(word.equals("end")) break;
            map = new char[3][3];
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    map[i][j] = word.charAt(idx++);
                }
            }
            int xCnt = count('X');
            int oCnt = count('O');
            boolean x_check = bingo('X');
            boolean o_check = bingo('O');
            if (xCnt == oCnt + 1) {  // x가 이김
                if (xCnt + oCnt == 9 && !bingo('O')) {
                    sb.append("valid").append("\n");
                } else if (!bingo('O') && bingo('X')) {
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            } else if (xCnt == oCnt) {  //o가 이김
                if (!bingo('X') && bingo('O')) {
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            } else {
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static boolean bingo(char x){
        if(map[0][0] == map[1][0] && map[1][0] == map[2][0] && map[2][0] == x) return true;
        if(map[0][0] == map[0][1] && map[0][1] == map[0][2] && map[0][2] == x) return true;
        if(map[1][0] == map[1][1] && map[1][1] == map[1][2] && map[1][2] == x) return true;
        if(map[2][0] == map[2][1] && map[2][1] == map[2][2] && map[2][2] == x) return true;
        if(map[0][1] == map[1][1] && map[1][1] == map[2][1] && map[2][1] == x) return true;
        if(map[0][2] == map[1][2] && map[1][2] == map[2][2] && map[2][2] == x) return true;
        if(map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[2][2] == x) return true;
        if(map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[2][0] == x) return true;
        return false;
    }
    static int count(char x){
        int cnt = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(map[i][j] == x){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
