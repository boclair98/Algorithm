import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dfs(n));
    }

    private static long dfs(int n) {
        if(n == 0) return 0;
        if(n <=2) return 1;
        return dfs(n-1) + dfs(n-2);

    }
}
