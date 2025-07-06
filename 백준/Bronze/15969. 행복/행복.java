import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr= new int[t];
        st = new StringTokenizer(br.readLine());
        int max_val = 0;
        int min_val = Integer.MAX_VALUE;
        for(int i = 0; i < t; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max_val = Math.max(max_val, arr[i]);
            min_val = Math.min(min_val, arr[i]);
        }
        System.out.println(max_val - min_val);

    }
}