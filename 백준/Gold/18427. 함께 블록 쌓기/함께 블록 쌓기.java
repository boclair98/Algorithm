import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m,h;
    static List<List<Integer>> list = new ArrayList<>();
    static int[][] dp = new int[51][1005];
    static int recur(int idx, int total){
        if(total > h) return 0;
        if(total == h) return 1;
        if(idx == n) return 0;
        if(dp[idx][total] != -1) return dp[idx][total];
        int ans = recur(idx+1, total);
        for(int number : list.get(idx)){
            if(total + number <= h){
                ans=recur(idx+1, total + number) + ans;
            }
        }
        return dp[idx][total] = ans % 10007;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 0; i < 51; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0,0));
    }
}
