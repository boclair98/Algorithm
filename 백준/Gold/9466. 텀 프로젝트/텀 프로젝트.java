import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k+1];
            int[] state = new int[k+1];
            cnt = 0;
//            boolean[] visited = new boolean[k+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=k; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j<=k; j++){
                if(state[j] == 0){
                    dfs(j,arr,state);
                }
            }

            System.out.println(k - cnt);

        }
    }

    private static void dfs(int num, int[] arr, int[] state) {
        state[num] = 1;
        int number = arr[num];
        if(state[number] == 0){
            dfs(number,arr,state);
        }else if(state[number] == 1){
            cnt++;
            for(int i = number; i!=num; i=arr[i]){
                cnt++;
            }
        }
        state[num] = 2;


    }


}
