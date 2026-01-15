import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> number = new ArrayList<>();
    static List<Integer> list;
    static void dfs(int idx){
        if(idx == n){
//            list = new ArrayList<>();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = number.get(i);
            }
            for(int i = n-1; i>=0; i--){
                for(int j = 0; j < i; j++){
                    nums[j] = nums[j] + nums[j+1];
                }
            }
            if(nums[0] == m){
                for (Integer i : number) {
                    System.out.print(i+" ");
                }
                System.exit(0);
            }

            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                number.add(arr[i]);
                dfs(idx+1);
                number.remove(number.size()-1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            arr[i] = i + 1;
        }
        dfs(0);

    }
}