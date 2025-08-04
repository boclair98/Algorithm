import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i = 0; i<n; i++){
            maps.put(arr[i], maps.getOrDefault(arr[i],0)+1);
            while(maps.get(arr[i]) > m){
                maps.put(arr[left],maps.get(arr[left])-1);
                left++;
            }
            max = Math.max(max,i-left+1);
        }
        System.out.println(max);

    }
}
