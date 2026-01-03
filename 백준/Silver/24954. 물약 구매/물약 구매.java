import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static List<List<int[]>>list = new ArrayList<>();
    static boolean[] visited = new boolean[15];
    static int[] arr = new int[15];
    static int max_val = Integer.MAX_VALUE;
    static void recur(int idx, int coin){
        if(coin>=max_val) return;
        if(idx == n+1){
            max_val = Math.min(max_val,coin);
            return;
        }

        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                for(int[] now : list.get(i)){
                    arr[now[0]]-=now[1];
                }
                if(arr[i] <= 0){
                    recur(idx+1,coin+1);
                }else{
                    recur(idx+1,coin+arr[i]);
                }
                visited[i] = false;
                for(int[] now : list.get(i)){
                    arr[now[0]]+=now[1];
                }

            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=n; i++){
            int s = Integer.parseInt(br.readLine());
            for(int j = 0; j<s; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(i).add(new int[]{a,b});
            }
        }
        recur(1,0);
        System.out.println(max_val);

    }
}