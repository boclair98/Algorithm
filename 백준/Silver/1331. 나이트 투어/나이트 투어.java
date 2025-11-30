import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited = new boolean[6][6];
    static int[] dx ={-2,-2,1,-1,-1,1,2,2};
    static int[] dy ={-1,1,-2,-2,2,2,-1,1};
    static int sx = -1;
    static int sy = -1;
    static int lx = -1;
    static int ly = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('B',1);
        map.put('C',2);
        map.put('D',3);
        map.put('E',4);
        map.put('F',5);
        String wx = br.readLine();
        sx = map.get(wx.charAt(0));
        sy = Integer.parseInt(String.valueOf(wx.charAt(1)))-1;
        lx = sx;
        ly = sy;
        visited[sx][sy] = true;
        while(count<36){
            String word = br.readLine();
            boolean ok = false;
            int x = map.get(word.charAt(0));
            int y = Integer.parseInt(String.valueOf(word.charAt(1)))-1;
            for(int i = 0; i<8; i++){
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                if(nx<0 || nx>=6 || ny<0 || ny>=6)continue;
                if(nx == x && ny == y){
                    if(visited[nx][ny]){
                        System.out.println("Invalid");
                        return;
                    }
                    ok = true;
                    visited[nx][ny] = true;
                    sx = nx;
                    sy = ny;
                    break;
                }
            }
            if(!ok){
                System.out.println("Invalid");
                return;
            }
            count++;
        }
        for(int i = 0; i<8; i++){
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx == lx && ny == ly){
                System.out.println("Valid");
                return;
            }
        }
        System.out.println("Invalid");

    }
}
