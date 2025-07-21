import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr1;
    static int[] arr2;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
            if(binarySeach(arr2[i])){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean binarySeach(int num){
        int start = 0;
        int end = n-1;
        while (start<=end){
            int mid = (start + end) / 2;

            if(num == arr1[mid]){
                return true;
            }else if( num < arr1[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
}



