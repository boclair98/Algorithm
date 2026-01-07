import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static void recur(int x, int y, int sz){
        if(check(x,y,sz)){
            if(map[x][y] == 0){
                System.out.print(0+"");
            }
            if(map[x][y] == 1){
                System.out.print(1+"");
            }
            return;
        }
        int size = sz / 2;
        System.out.print("(");
        recur(x,y,size);
        recur(x,y+size,size);
        recur(x+size,y,size);
        recur(x+size,y+size,size);
        System.out.print(")");

    }

    private static boolean check(int x, int y, int sz) {
        int number = map[x][y];
        for(int i = x; i<x+sz; i++){
            for(int j = y; j<y+sz; j++){
                if(map[i][j] != number) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(String.valueOf(word.charAt(j)));
            }
        }
        recur(0,0,n);

    }
}