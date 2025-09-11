import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,l;
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int total = 0;
        for(int i = 0; i<n; i++){
            count = 1;
            boolean found = false;
            for(int j = 0; j<n-1; j++){
                if(map[i][j] == map[i][j+1]){
                    count++;
                }else if(map[i][j]+1 == map[i][j+1] && count >=l){
                    count = 1;
                }else if(map[i][j] -1 == map[i][j+1] && count >=0){
                    count = 1 -l ;
                }else{
                    found = true;
                    break;
                }
            }
            if(!found && count >=0){
                total++;
            }
        }
        for(int i = 0; i<n; i++){
            count = 1;
            boolean found = false;
            for(int j = 0; j<n-1; j++){
                if(map[j][i] == map[j+1][i]){
                    count++;
                }else if(map[j][i]+1 == map[j+1][i] && count >=l){
                    count = 1;
                }else if(map[j][i] -1 == map[j+1][i] && count >=0){
                    count = 1 -l ;
                }else{
                    found = true;
                    break;
                }
            }
            if(!found && count >=0){
                total++;
            }
        }
        System.out.println(total);

    }
}

