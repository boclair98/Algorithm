import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,a,b,c;
    static int[][] map;
    static void recur(int x,int y, int num){
        if(check(x,y,num)){
            if(map[x][y] == -1) a++;
            if(map[x][y] == 0) b++;
            if(map[x][y] == 1) c++;
            return;
        }
        int size = num / 3;

        recur(x,y,size);
        recur(x,y+size,size);
        recur(x,y+size*2,size);
        recur(x+size,y,size);
        recur(x+size,y+size,size);
        recur(x+size,y+size*2,size);
        recur(x+size*2,y,size);
        recur(x+size*2,y+size,size);
        recur(x+size*2,y+size*2,size);

    }

    private static boolean check(int x, int y, int num) {
        int number = map[x][y];
        for(int i = x; i<x+num; i++){
            for(int j = y; j<y+num; j++){
                if(map[i][j]!=number) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0,0,n);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}