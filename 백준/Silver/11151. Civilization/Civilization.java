import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,t;
    static int[] arr;
    static int[][] farm;
    static boolean[] visited;
    static int min;
    static void dfs(int idx, int h,int s, int c,int cnt){
        if(h>=arr[0] && s>=arr[1] && c>=arr[2]){
            min = Math.min(min,cnt);
            return;
        }
        if(idx == n || cnt > min) return;
        dfs(idx+1,h+farm[idx][0],s+farm[idx][1],c+farm[idx][2],cnt+1);
        dfs(idx+1,h,s,c,cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-->0){
            n = Integer.parseInt(br.readLine());
            arr = new int[3];
            farm = new int[n][3];
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    farm[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0,0,0,0);
            if(min == Integer.MAX_VALUE){
                sb.append("game over").append("\n");
            }else{
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }
}