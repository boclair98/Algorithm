import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t,n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t -- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = -Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                int count = arr[i];
                for(int j = i+1; j < n; j++){
                    max = Math.max(max, count);
                    count += arr[j];
                }
                max = Math.max(max, count);
            }
            System.out.println(max);
        }
    }
}
