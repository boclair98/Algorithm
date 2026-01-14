import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, m;
    static int[] arr1,arr2;
    static boolean binarySearch(int num){
        int start = 0;
        int end = m-1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr2[mid] == num){
                return true;
            }
            if(arr2[mid] < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            arr1 = new int[n];
            arr2 = new int[m];
            for(int i = 0; i < n; i++){
                arr1[i] = Integer.parseInt(br.readLine());
            }
            for(int i = 0; i < m; i++){
                arr2[i] = Integer.parseInt(br.readLine());
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                if(binarySearch(arr1[i])) count++;
            }
            System.out.println(count);
        }
    }
}