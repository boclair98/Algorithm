import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static StringTokenizer st;
    static boolean[] visited;
    static int[] num;
    static int[] arr;
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        num = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(answer);

    }

    private static void dfs(int idx) {
        if(idx == n){
            int sum = 0;
            for(int i = 0; i< n-1; i++){
                sum+=Math.abs(arr[i]-arr[i+1]);
            }
            answer = Math.max(sum, answer);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = num[i];
                dfs(idx+1);
                visited[i] = false;
            }
        }
    }

}

