import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx ={1,0,-1,0,-1,-1,1,1};
    static int[] dy ={0,1,0,-1,-1,1,-1,1};
    static Character[] alpha ={'A','B','C','D','E','F','G','H'};
    static int[][] map = new int[8][8];
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] word = br.readLine().split(" ");
        String x = word[0];
        String y = word[1];
        int n = Integer.parseInt(word[2]);
        int kx = -1;
        int ky = -1;
        int sx = -1;
        int sy = -1;
        ky = x.charAt(0) -'A';
        kx = 8 - (x.charAt(1) - '0');

        sy = y.charAt(0) -'A';
        sx = 8 - (y.charAt(1) - '0');
//        System.out.println(kx+" "+ky);
//        System.out.println(sx+" "+sy);
        map[sx][sy] = 2;
        map[kx][ky] = 1;
//        visited = new boolean[8][8];
        int idx = -1;
        for(int i = 0; i<n; i++){
            String alp = br.readLine();
            if(alp.equals("B")) idx = 0;
            if(alp.equals("T")) idx = 2;
            if(alp.equals("L")) idx = 3;
            if(alp.equals("R")) idx = 1;
            if(alp.equals("RT")) idx = 5;
            if(alp.equals("LT")) idx = 4;
            if(alp.equals("RB")) idx = 7;
            if(alp.equals("LB")) idx = 6;

            int knx = kx + dx[idx];
            int kny = ky + dy[idx];
            if(knx<0 || knx >=8 || kny<0 || kny>=8) continue;
            if(map[knx][kny] == 2){
                int snx = sx + dx[idx];
                int sny = sy + dy[idx];
                if(snx<0 || snx >=8 || sny<0 || sny>=8) continue;
                map[snx][sny] = 2;
                map[knx][kny] = 0;
                sx = snx;
                sy = sny;
            }
            map[knx][kny] = 1;
            map[kx][ky] = 0;
            kx = knx;
            ky = kny;

        }

//        for(int i = 0; i<8; i++){
//            for(int j = 0; j<8; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println((char)(ky + 'A') + "" + (8 - kx));
        System.out.println((char)(sy + 'A') + "" + (8 - sx));


    }

}
