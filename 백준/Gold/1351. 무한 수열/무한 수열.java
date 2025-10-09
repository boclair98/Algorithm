import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long n,p,q;
    static Map<Long,Long> map = new HashMap<>() ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        System.out.println(dfs(n));
    }

    private static long dfs(long idx) {
        if(idx == 0) return 1;
        if(map.containsKey(idx)) return map.get(idx);
        long ans = dfs(idx / p) + dfs(idx / q);
        map.put(idx,ans);
        return ans;
    }


}
