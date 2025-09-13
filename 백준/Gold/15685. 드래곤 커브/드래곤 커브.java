import java.io.*;
import java.util.*;

public class Main {
    static int n,ans;
    static int[][] map = new int[101][101];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static StringTokenizer st ;
    static int[] dir = new int[]{1,2,4,8,16,32,64,128,256,512,1024};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            moves(x,y,d,g);
        }
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1){
                    ans++;
                }
            }
//            System.out.println();
        }
        System.out.println(ans);
    }

    private static void moves(int x, int y, int d, int g) {
        List<Integer> dragon = new ArrayList<>();
        dragon.add(d);
        for(int i = 0; i<g; i++){
            for(int j = dragon.size()-1; j>=0; j--){
                dragon.add((dragon.get(j)+1)%4);
            }
        }
        map[x][y] = 1;
        for(Integer dir:dragon){
            x = x + dx[dir];
            y = y + dy[dir];
            if(x<0 || x>=101 || y<0 || y>=101) continue;
            map[x][y] = 1;
        }


    }
}
