import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = '.';
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=m; i++){

            int x = Integer.parseInt(st.nextToken());
            if(i%3 == 0){
                int cnt = 0;
                int count = 0;
                while(cnt < x){
                    map[n-1-count][i-1] = '#';
                    cnt++;
                    count++;
                }
                if(x < k){
                    map[n-k][i-1] = '-';
                    for(int j = n-1-count; j>n-k; j--){
                        map[j][i-1] = '|';
                    }
                }else{
                    map[n-k][i-1] = '*';
                }

            }else{
                int cnt = 0;
                int count = 0;
                while(cnt < x){
                    map[n-1-count][i-1] = '#';
                    cnt++;
                    count++;
                }
                if(x < k){
                    map[n-k][i-1] = '-';
                }else{
                    map[n-k][i-1] = '*';
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
