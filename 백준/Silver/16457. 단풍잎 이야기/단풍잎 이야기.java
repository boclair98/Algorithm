import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m,k;
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static void recur(int idx, int count){
        if(count == n){
            int cnt = 0;
            for(int[] now: list){
                boolean check = true;
                for(int s : now){
                    if(!visited[s]){
                        check = false;
                        break;
                    }
                }
                if(check) cnt++;
            }
            max = Math.max(max,cnt);
            return;
        }
        for(int i = idx; i<=2*n; i++){
            visited[i] = true;
            recur(i+1,count+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[2*n+1];

        //스킬 연결
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int[] pa = new int[k];
            for(int j = 0; j < k; j++){
                pa[j] = Integer.parseInt(st.nextToken());
            }
            list.add(pa);
        }

        recur(1,0);
        System.out.println(max);
    }
}