import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <=n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int[] arr = new int[a];
            for(int j = 0; j < a; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int largegap = 0;
            for(int j = 0 ; j < a-1; j++){
                largegap = Math.max(largegap,arr[j+1]-arr[j]);
            }
            System.out.println("Class "+i);
            System.out.println("Max "+(arr[a-1])+", Min "+arr[0]+", Largest gap "+(largegap));
        }


    }


}
