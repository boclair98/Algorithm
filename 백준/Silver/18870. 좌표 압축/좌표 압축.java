import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        number = new int[n];
        for(int i = 0; i<n; i++){
            number[i] = arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(Integer s : arr){
            if(!map.containsKey(s)){
                map.put(s,cnt++);
            }
        }
        for(int i = 0; i<n; i++){
            sb.append(map.get(number[i])+" ");
        }
        System.out.println(sb);

    }

}