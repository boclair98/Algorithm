import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static StringTokenizer st;
    static boolean sosu(int num){
        if(num < 2) return false;
        for(int i = 2; i*i<=num; i++){
            if(num % i == 0)return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = n; i<=m; i++){
            if(sosu(i)){
                System.out.println(i);
            }
        }
    }
}
