import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        count = new int[n][n];
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            for(int j = 0; j < n; j++){
                if(i == j){
                    map[i][j] = 0;
                    continue;
                }
                if(word.charAt(j) == 'Y'){
                    map[i][j] = 1;
                }else{
                    map[i][j] = 10000000;
                }
            }
        }

        //워셜
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] > map[i][k]+map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int max_val = 0;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(map[i][j] <=2) cnt++;
            }
            max_val = Math.max(max_val,cnt);
        }
        System.out.println(max_val);
    }
}