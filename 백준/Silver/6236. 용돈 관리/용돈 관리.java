import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m;
    static int[] cost;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cost = new int[n];
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(br.readLine());
            start = Math.max(start,cost[i]);
            end+=cost[i];
        }
        int answer = 0;
        while(start<=end){
            int mid = (start + end) / 2;
            int cnt = 1;
            int total_cost = mid;
            for(int i = 0; i < n; i++){
                if(total_cost < cost[i]){
                    total_cost = mid;
                    cnt++;
                }
                total_cost-=cost[i];
            }
            if(cnt <= m ){
                end = mid - 1;
                answer = mid;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(answer);

    }
}