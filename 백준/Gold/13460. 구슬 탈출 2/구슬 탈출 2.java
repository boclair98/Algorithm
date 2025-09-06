import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m,count;
    static char[][] maps;
    static boolean[][][][] visited = new boolean[11][11][11][11];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int SRX,SRY,SBX,SBY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new char[n][m];
        for(int i = 0 ; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<m; j++){
                maps[i][j] = word.charAt(j);
                if(maps[i][j] =='R'){
                    SRX = i;
                    SRY = j;
                }
                if(maps[i][j] == 'B'){
                    SBX = i;
                    SBY = j;
                }
            }
        }
        bfs();
    }
    public static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{SRX,SRY,SBX,SBY,0});
        visited[SRX][SRY][SBX][SBY] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int rx = cur[0];
            int ry = cur[1];
            int bx = cur[2];
            int by = cur[3];
            int count = cur[4];
            if(count>=10){
                System.out.println(-1);
                return;
            }
            if(maps[rx][ry] == 'O' && maps[bx][by]!='O'){
                System.out.println(count);
                return;
            }
            for(int i = 0; i<4; i++){
                int nrx = rx;
                int nry = ry;
                boolean redhole = false;
                boolean bluehole = false;
                while(true){
                    nrx = nrx + dx[i];
                    nry = nry + dy[i];
                    if(maps[nrx][nry] == 'O'){
                        redhole = true;
                        break;
                    }
                    if(maps[nrx][nry] =='#'){
                        nrx-=dx[i];
                        nry-=dy[i];
                        break;
                    }
                }
                int nbx = bx;
                int nby = by;
                while(true){
                    nbx = nbx + dx[i];
                    nby = nby + dy[i];
                    if(maps[nbx][nby] == 'O'){
                        bluehole = true;
                        break;
                    }
                    if(maps[nbx][nby] =='#'){
                        nbx-=dx[i];
                        nby-=dy[i];
                        break;
                    }
                }
                if(bluehole) continue;
                if(redhole){
                    System.out.println(count+1);
                    return;
                }

                if(nrx == nbx && nry == nby && maps[nrx][nry]!='O'){
                    int x1 = Math.abs(nrx-rx);
                    int x2 = Math.abs(nbx-bx);
                    int y1 = Math.abs(nry-ry);
                    int y2 = Math.abs(nby-by);
                    int total1 = x1 + y1;
                    int total2 = x2 + y2;
                    if(total1 > total2){
                        nrx-=dx[i];
                        nry-=dy[i];
                    }else{
                        nbx-=dx[i];
                        nby-=dy[i];
                    }
                }

                if(!visited[nrx][nry][nbx][nby]){
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new int[]{nrx,nry,nbx,nby,count+1});
                }
            }
        }
        System.out.println(-1);
    }
}
