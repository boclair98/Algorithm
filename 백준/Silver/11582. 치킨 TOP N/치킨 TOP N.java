import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, k;
    static List<Integer> list;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        int idx = n / k;

        for(int i = 0; i < n; i+=idx){
            list = new ArrayList<>();
            for(int j = i; j<i+idx; j++){
                list.add(arr[j]);
            }
            Collections.sort(list);
            for (Integer num : list) {
                sb.append(num+" ");
            }
        }
        System.out.println(sb.toString());

    }
}