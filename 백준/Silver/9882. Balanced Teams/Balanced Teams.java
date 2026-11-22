import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr = new int[12];
    static int[] team = new int[4];
    static int[] sum = new int[4];
    static int total = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 12; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        backTracking(0);
        System.out.println(total);
    }
    static void backTracking(int idx){
        if(idx == 12){
            //최댓값 최솟값 계산
            int max = 0;
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < 4; i++){
                max = Math.max(max,sum[i]);
                min = Math.min(min,sum[i]);
            }
            total = Math.min(total,max-min);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(team[i] < 3){
                team[i]++;
                sum[i]+=arr[idx];
                backTracking(idx+1);
                team[i]--;
                sum[i]-=arr[idx];
            }
        }
    }
}
