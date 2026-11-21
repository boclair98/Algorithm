import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[] arr1, arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        //st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int number = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(number));
        }
    }
    static int binarySearch(int num){
        int start = 0;
        int end = n - 1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr1[mid] == num) return 1;
            if(arr1[mid] < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
         }
        return 0;
    }
}
