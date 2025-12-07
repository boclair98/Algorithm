import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,k;
    static int[][] map;
    static boolean[][] visited1,visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[2][100010];
        visited1 = new boolean[2][100010];
        visited2 = new boolean[2][100010];
        for(int i = 0; i<2; i++){
            String word = br.readLine();
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(word.charAt(j)));
            }
        }
        if(bfs()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    private static boolean bfs() {
        int[] dx ={1,-1,k};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0,0});
        visited1[0][0] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int idx = cur[2];
            for(int i = 0; i<3; i++){
                int nx = x;
                int ny = y + dx[i];
                if(ny>=n) return true;

                if(i == 2){
                    if(nx == 0){
                        nx = 1;
                    }else{
                        nx = 0;
                    }
                }
                if(ny < 0) continue;
                if(map[nx][ny] == 0) continue;
                if(visited1[nx][ny]) continue;
                if(ny<=idx) continue;
                dq.add(new int[]{nx,ny,idx+1});
                visited1[nx][ny] = true;
            }


        }
        return false;
    }
}