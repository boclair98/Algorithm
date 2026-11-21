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
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int number = Integer.parseInt(st.nextToken());
            int a = binarySearch1(number);
            int b = binarySearch(number);
            if(a == -1 || b == -1){
                sb.append(0).append(" ");
            }else{
                sb.append(a-b+1).append(" ");
            }
        }
        System.out.println(sb);
    }
    static int binarySearch(int num){
        int start = 0;
        int end = n - 1;
        int idx = -1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr1[mid] == num){
                idx = mid;
                end = mid - 1;
            }
            if(arr1[mid] < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return idx;
    }
    static int binarySearch1(int num){
        int start = 0;
        int end = n - 1;
        int idx2 = -1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr1[mid] == num){
                idx2 = mid;
                start = mid + 1;
            }else if(arr1[mid] < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return idx2;
    }
}
