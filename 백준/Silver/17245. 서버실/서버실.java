import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, end, max, start, ans;
    static long total;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
                total+=map[i][j];
            }
        }
        long goal = (total+1) / 2;
        start = 1;
        end = max;
        while(start<=end){
            int mid = (start + end) / 2;
            long tot = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(mid >= map[i][j]){
                        tot+=map[i][j];
                    }else{
                        tot+=mid;
                    }
                }
            }
            if(tot >= goal){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
