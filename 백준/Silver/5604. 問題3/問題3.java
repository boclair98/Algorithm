import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i = 1; i<=n; i++){
            arr[i-1] = n-i+1;
        }
        backTracking(0,0);
        System.out.println(sb);
    }
    static void backTracking(int idx, int total){
        if(total > n ) return;
        if(total == n){
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = idx; i < n; i++){
            list.add(arr[i]);
            backTracking(i,total+arr[i]);
            list.remove(list.size()-1);
        }
    }
}
