import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n -- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[a];
            int[] arr2 = new int[b];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < a; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < b; i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int count = 0;
            for(int i = 0; i < a; i ++){
                for(int j = 0; j < b; j ++){
                    if(arr1[i] > arr2[j]){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
