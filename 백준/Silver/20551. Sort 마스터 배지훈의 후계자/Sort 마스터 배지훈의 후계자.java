import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i = 0; i<c; i++){
            int check = Integer.parseInt(br.readLine());
            int cnt = binary(check);
            if(cnt == -1){
                System.out.println(-1);
            }else{
                System.out.println(cnt);
            }
        }
    }
    static int binary(int num){
        int start = 0;
        int end = n-1;
        int answer = -1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] == num){
                answer = mid;
                end = mid - 1;
            }else if(arr[mid] < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return answer;
    }
}
