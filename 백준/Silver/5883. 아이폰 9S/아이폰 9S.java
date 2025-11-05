import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int max_count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }
        for (Integer num : set) {
            max_count = Math.max(max_count, check(num));
        }
        System.out.println(max_count);
    }
    static int check(int num){
        int count = 0;
        int prev = -1;
        int total = 0;
        for (int number : arr) {
            if(number == num) continue;
            if(prev == number){
                count++;
            }else{
                count = 1;
            }
            prev = number;
            total = Math.max(total, count);
        }
        return total;
    }
}
