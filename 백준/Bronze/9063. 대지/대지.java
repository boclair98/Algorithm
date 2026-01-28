import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t;
    static int[][] arr= new int[1000000][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int x_max = -Integer.MAX_VALUE;
        int x_min = Integer.MAX_VALUE;
        for(int i = 0; i < t; i++){
            if(arr[i][0] > x_max){
                x_max =arr[i][0];
            }
            if(arr[i][0] < x_min){
                x_min = arr[i][0];
            }
        }
        int y_max = -Integer.MAX_VALUE;
        int y_min = Integer.MAX_VALUE;
        for(int i = 0; i < t; i++){
            if(arr[i][1] > y_max){
                y_max =arr[i][1];
            }
            if(arr[i][1] < y_min){
                y_min = arr[i][1];
            }
        }
        System.out.println((x_max-x_min) * (y_max-y_min));
    }
}