import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, white, blue;
    static int[][] map;
    static void recur(int x,int y, int sz){
        if(check(x,y,sz)){
            if(map[x][y] == 1) blue++;
            if(map[x][y] == 0) white++;
            return;
        }
        int size = sz / 2;

        recur(x,y,size);
        recur(x,y+size,size);
        recur(x+size,y,size);
        recur(x+size,y+size,size);
    }

    private static boolean check(int x, int y, int sz) {
        int num = map[x][y];
        for(int i = x; i<x+sz; i++){
            for(int j = y; j<y+sz; j++){
                if(map[i][j] != num) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
}