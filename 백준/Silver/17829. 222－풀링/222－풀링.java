import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] arr;
//    static int[][] map;
    static int recur(int x, int y, int sz){
        if(sz == 2){
            int count = 0;
            int[] arrs = new int[4];
            for(int i = x; i<x+sz; i++){
                for(int j = y; j<y+sz; j++){
                    arrs[count] = arr[i][j];
                    count++;
                }
            }
            Arrays.sort(arrs);
            return arrs[2];
        }

        int size = sz / 2;
        int count = 0;
        int[] arrs = new int[4];
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                arrs[count] = recur(x+(i*size),y+(j*size),size);
                count++;
            }
        }
        Arrays.sort(arrs);
        return arrs[2];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recur(0,0,n));

    }
}