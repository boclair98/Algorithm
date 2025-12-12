import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m,t;
    static int[] num1,num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-->0){
            n = Integer.parseInt(br.readLine());
            num1 = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++){
                num1[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());
            num2 = new int[m];
            st = new StringTokenizer(br.readLine());
            Arrays.sort(num1);
            for(int i = 0; i<m; i++){
                num2[i] = Integer.parseInt(st.nextToken());
                if(binarySearch(num2[i])){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
    static boolean binarySearch(int num){
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid =(start + end) / 2;
            if(num1[mid] == num){
                return true;
            }
            if(num1[mid] < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}