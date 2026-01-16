import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,k;
    static int[][] map;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> number = new ArrayList<>();
    static void recur(int idx){
        if(list.size() == k){
            int size = 0;
            for(int i = 0 ; i < k; i++){
                for(int j = i+1; j < k; j++){
                    size+=map[list.get(i)][list.get(j)];
                }
            }
            number.add(size);
            
            return;
        }
        for(int i = idx; i < n; i++){
            list.add(arr[i]);
            recur(i+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        map = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(k == 1){
            System.out.println(0);
            return;
        }
        recur(0);
        Collections.sort(number);
        System.out.println(number.get(number.size()-1));


    }

}