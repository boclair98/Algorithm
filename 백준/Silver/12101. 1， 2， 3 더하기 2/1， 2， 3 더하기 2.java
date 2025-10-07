import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    static int n, m,total_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dfs(0);
        if(total_cnt < m){
            System.out.println(-1);
        }
    }

    private static void dfs(int sum) {
        if(sum > n) return;
        if(sum == n){
            total_cnt++;
            if(total_cnt == m){
                for(int i = 0; i<list.size(); i++){
                    if(list.size()-1 == i){
                        System.out.print(list.get(i));
                    }else {
                        System.out.print(list.get(i)+"+");
                    }
                }
            }
            return;
        }
        for(int i = 1; i<=3; i++){
            list.add(i);
            dfs(sum+i);
            list.remove(list.size()-1);
        }
    }
}
