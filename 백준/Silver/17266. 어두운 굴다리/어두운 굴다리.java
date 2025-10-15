import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[m];
        for(int i = 0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int end = n;
        int number = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(all(mid)){
                number = mid;
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(number);
    }

    private static boolean all(int mid) {
        int last = 0;
        for (int num : arr) {
            int left = num - mid;
            if(left > last) return false;
            last = num + mid;
        }
        return last>=n;

    }
}
