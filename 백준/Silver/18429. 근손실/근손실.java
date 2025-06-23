import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static int n,k,count;
    static boolean[] visited;
    static int[] arr;
    static int start = 500;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        BackTracking(0,start);
        System.out.println(count);
    }

    private static void BackTracking(int depth, int start) {
        if(start < 500){
            return;
        }
        if(depth == n){
            if(start >= 500){
                count++;
            }
            return;
        }
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                visited[i] = true;
                BackTracking(depth+1,start+arr[i]-k);
                visited[i] = false;
            }
        }

    }


}