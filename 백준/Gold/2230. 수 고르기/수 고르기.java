import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        int min_value = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        int left = 0, right = 0;
        while(right < n){
            int diff = num[right] - num[left];
            if(diff >= m){
                min_value = Math.min(min_value, diff);
                left++;
            } else {
                right++;
            }
            if(left > right){
                right = left;
            }
        }
        System.out.println(min_value);
    }
}