import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        String answer ="";
        int up = 1;
        int down = 1;
        int max = 1;
        for(int i = 0; i<n-1; i++){
            if(arr[i] < arr[i+1]){
                up++;
                down = 1;
            }else if(arr[i] > arr[i+1]){
                down++;
                up = 1;
            }else{
                up++;
                down ++;
            }
            max = Math.max(max,Math.max(up,down));
        }
        System.out.println(max);
    }
}