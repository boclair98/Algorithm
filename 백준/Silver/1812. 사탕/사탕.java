import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static StringTokenizer st;
    static int[] arr;
    static int[] num;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = new int[n];
        int total = 0;
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            total+=arr[i];
        }
        int odd = 0;
        for(int i = 1; i<n; i+=2){
            odd+=arr[i];
        }
        answer[0] = (total/2) - odd;
        for(int i = 1; i<n; i++){
            answer[i] = arr[i-1] - answer[i-1];
        }
        for (int i : answer) {
            System.out.println(i);
        }

    }

}
