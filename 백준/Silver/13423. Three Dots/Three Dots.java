import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t,n;
    static int[] arr;
    static boolean binary(int num){
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] == num) return true;
            if(arr[mid] < num) start = mid + 1;
            if(arr[mid] > num) end = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-->0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = i+1; j<n;j++){
                    int dist = arr[j] - arr[i];
                    int target = arr[j] + dist;
                    if(target<=arr[n-1] && binary(target)){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}