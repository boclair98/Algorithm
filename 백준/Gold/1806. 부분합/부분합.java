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
        int total = 0 ;
        int left = 0, right = 0;
        int min_value = Integer.MAX_VALUE;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(right < n ){
            total+=arr[right];
            while(total>=m){
                min_value = Math.min(min_value,right - left + 1);
                total-=arr[left];
                left++;
            }
            right++;
        }
        if(min_value == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(min_value);
        }
    }
}