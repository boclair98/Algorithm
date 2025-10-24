import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int answer = 0;
    static int[][] map ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(word.charAt(j)));
            }
        }

        int idx = 0;
        while(idx < n){
            for(int i = 0; i<n-idx; i++){
                for(int j = 0; j<m-idx; j++){
                    if (map[i][j] == map[i+idx][j] &&
                            map[i+idx][j] == map[i+idx][j+idx] &&
                            map[i+idx][j+idx] == map[i][j+idx]) {
                        answer = Math.max(answer,(idx+1) *(idx+1));
                    }
                }
            }
            idx++;
        }
        System.out.println(answer);


    }
}
