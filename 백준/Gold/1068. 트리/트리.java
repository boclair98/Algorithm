import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,k;
    static List<List<Integer>> list = new ArrayList<>();
    static int cnt;
    static void dfs(int start){
        if(start == k) return;
        int child = 0;
        for(int s: list.get(start)){
            if(s == k) continue;
            child++;
            dfs(s);
        }
        if(child == 0) cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i <n; i++){
            list.add(new ArrayList<>());
        }
        int root = -1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == -1){
                root = i;
                continue;
            }
            list.get(num).add(i);
        }
        k = Integer.parseInt(br.readLine());
        dfs(root);
        System.out.println(cnt);
    }

}