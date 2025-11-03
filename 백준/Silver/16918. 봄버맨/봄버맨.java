import java.io.*;
import java.util.*;

public class Main {
    static int r,c,n;
    static char[][] map;
    static StringTokenizer st;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for(int i = 0; i<r; i++){
            String word = br.readLine();
            for(int j = 0; j<c; j++){
                map[i][j] = word.charAt(j);
            }
        }
        if(n == 1){
            print();
        }else if (n % 2 == 0){
            second();
            print();
        } else if (n%4 == 3){
            first();
            second();
            third();
            print();
        }else if(n % 4 == 1){
            first();
            second();
            third();
            first();
            second();
            third();
            print();
        }
    }
    static void print(){
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                System.out.print(map[i][j] + "");
            }
            System.out.println();
        }
    }
    static void first(){
        q = new ArrayDeque<>();
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(map[i][j] =='O'){
                    q.add(new int[]{i,j});
                }
            }
        }
    }
    static void second() {
        for (int i = 0; i < r; i++) {
            Arrays.fill(map[i], 'O');
        }
    }
    static void third(){
        visited = new boolean[r][c];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            map[x][y] = '.';
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                map[nx][ny] = '.';
            }
        }
    }
}
