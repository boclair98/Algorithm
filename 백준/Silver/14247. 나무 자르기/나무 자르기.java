import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long n,count;
    static long[] arr1,arr2;
    static int max = -1;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        arr1 = new long[(int)n];
        arr2 = new long[(int)n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Long.parseLong(st.nextToken());
            count+=arr1[i];
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr2);
        for(int i = 0; i < n; i++) {
            count+=(arr2[i] * i);
        }
        System.out.println(count);
    }
}
