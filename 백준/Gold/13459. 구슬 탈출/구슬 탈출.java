import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static char[][] map;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static boolean[][][][] visited = new boolean[11][11][11][11];
    static int rx, ry, bx, by;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = word.charAt(j);
                if(map[i][j] == 'R'){
                    rx = i;
                    ry = j;
                }
                if(map[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }

        bfs();

    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{rx,ry,bx,by,0});
        visited[rx][ry][bx][by] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int redX = cur[0];
            int redY = cur[1];
            int blueX = cur[2];
            int blueY = cur[3];
            int count = cur[4];
            if(count>=10){
                System.out.println(0);
                return;
            }
            if(map[redX][redY] == 'O' && map[blueX][blueY] != 'O'){
                System.out.println(1);
                return;
            }

            for(int i = 0; i < 4; i++){
                int red1 =  redX;
                int red2 =  redY;
                boolean redHole = false;
                boolean blueHole = false;
                while(true){
                    if(map[red1][red2] == 'O'){
                        redHole = true;
                        break;
                    }
                    if(map[red1][red2] == '#'){
                        red1 -= dx[i];
                        red2 -= dy[i];
                        break;
                    }
                    red1+=dx[i];
                    red2+=dy[i];
                }
                int blue1 = blueX;
                int blue2 = blueY;
                while(true){
                    if(map[blue1][blue2] == 'O'){
                        blueHole = true;
                        break;
                    }
                    if(map[blue1][blue2] == '#'){
                        blue1 -= dx[i];
                        blue2 -= dy[i];
                        break;
                    }
                    blue1+=dx[i];
                    blue2+=dy[i];
                }

                if(blueHole) continue;
                if(redHole){
                    System.out.println(1);
                    return;
                }

                if(red1 == blue1 && red2 == blue2 && map[red1][red2] !='O'){
                    int r1 = Math.abs(red1 - redX);
                    int r2 = Math.abs(red2 - redY);
                    int b1 = Math.abs(blue1 - blueX);
                    int b2 = Math.abs(blue2 - blueY);
                    if(r1+r2 > b1+b2){
                        red1-=dx[i];
                        red2-=dy[i];
                    }else{
                        blue1-=dx[i];
                        blue2-=dy[i];
                    }
                }

                if(!visited[red1][red2][blue1][blue2]){
                    visited[red1][red2][blue1][blue2] = true;
                    q.add(new int[]{red1,red2,blue1,blue2,count+1});
                }

            }

        }
        System.out.println(0);

    }
}

