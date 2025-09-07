import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, tailx,taily,dir,sx,sy,count;
    static int[][] map;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static boolean[][] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Character> q2 = new ArrayDeque<>();

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            map[k-1][j-1] = 1;
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            q1.add(Integer.parseInt(st.nextToken()));
            q2.add(st.nextToken().charAt(0));
        }
        dir = 0;
        sx = 0;
        sy = 0;
        tailx = 0;
        taily = 0;
        visited[sx][sy] = true;
        Queue<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0,0});

        while(true){
            count++;
            int nx = sx + dx[dir];
            int ny = sy + dy[dir];
            if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]) break;
            sx = nx;
            sy = ny;
            visited[sx][sy] = true;
            snake.add(new int[]{sx,sy});
            if(map[sx][sy] == 1){
                map[sx][sy] = 0;
            }else{
                int[] cur = snake.poll();
                visited[cur[0]][cur[1]] = false;
                tailx = tailx+dx[dir];
                taily = taily+dy[dir];
            }

            if(!q1.isEmpty()&&q1.peek() == count ){
                if(q2.peek() == 'L'){
                    dir = (dir+3) % 4;
                }else{
                    dir = (dir + 1) % 4;
                }
                q1.poll();
                q2.poll();
            }
        }
        System.out.println(count);


    }


}
