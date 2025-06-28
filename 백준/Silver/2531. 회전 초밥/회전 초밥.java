import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            int[] menu = new int[d+1];
            menu[c] = 1;
            int total = 1;
            for(int j = 0; j<k; j++){
                int kind = arr[(i+j)%n];
                if(menu[kind] == 0){
                    total++;
                }
                menu[kind]++;
            }
            max = Math.max(max, total);
        }
        System.out.println(max);




    }
}