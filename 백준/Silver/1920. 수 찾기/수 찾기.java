import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int check = Integer.parseInt(st.nextToken());
            if(binary(check)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
    static boolean binary(int num){
        int start = 0;
        int end = n - 1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] == num){
                return true;
            }else if(arr[mid] < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
