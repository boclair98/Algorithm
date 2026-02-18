import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static char now;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i<=n; i++){
            map = new char[3][3];
            for(int j = 0; j <3; j++){
                String word = br.readLine();
                for(int k = 0; k < 3; k++){
                    map[j][k] = word.charAt(k);
                }
            }
            now = br.readLine().charAt(0);
            for(int j = 0; j < 3 ; j++){
                if(check(j,0,j,1,j,2)){
                    System.out.println("Case "+i+":");
                    show();
                    break;
                }
            }
            for(int j = 0; j < 3; j++){
                if(check(0,j,1,j,2,j)){
                    System.out.println("Case "+i+":");
                    show();
                    break;
                }
            }
            if(check(0,0,1,1,2,2)){
                System.out.println("Case "+i+":");
                show();
                continue;
            }
            if(check(0,2,1,1,2,0)){
                System.out.println("Case "+i+":");
                show();
                continue;
            }
        }
    }
    static void show(){
        for(int i = 0; i <3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }
    }
    static boolean check(int r1,int c1, int r2,int c2, int r3, int c3){
        int count = 0;
        if(map[r1][c1] == now) count++;
        if(map[r2][c2] == now) count++;
        if(map[r3][c3] == now) count++;

        if(count == 2){
            if(map[r1][c1] == '-'){
                map[r1][c1] = now;
                return true;
            }
            if(map[r2][c2] == '-'){
                map[r2][c2] = now;
                return true;
            }if(map[r3][c3] == '-'){
                map[r3][c3] = now;
                return true;
            }
        }
        return false;
    }

}