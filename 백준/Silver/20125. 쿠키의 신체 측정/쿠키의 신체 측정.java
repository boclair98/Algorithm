import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<n; j++){
                map[i][j] = word.charAt(j);
            }
        }
        int headx = -1;
        int heady = -1;
        int tailx = -1;
        int taily = -1;
        for(int i = 0; i<n; i++){
            boolean flag = false;
            for(int j = 0; j<n; j++){
                if(map[i][j] == '*'){
                    headx = i+1;
                    heady = j;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        for(int i = 0; i<n; i++){
            if(map[i][heady] == '*'){
                tailx = i;
            }
        }
        taily = heady;

        System.out.println(headx+1+" "+(heady+1));
        int left = 0;
        int right = 0;
        int head = 0;
        int leftleg = 0;
        int rightleg = 0;

        for(int i = headx; i<tailx; i++){
            if(map[i][heady]=='*'){
                head++;
            }
        }
        for(int i = heady-1; i>=0; i--){
            if(map[headx][i] == '*'){
                left++;
            }
        }
        for(int i = heady+1; i<n; i++){
            if(map[headx][i] =='*') right++;
        }
        for(int i = tailx+1; i<n; i++){
            if(map[i][taily-1] == '*') leftleg++;
        }
        for(int i = tailx+1; i<n; i++){
            if(map[i][taily+1] == '*') rightleg++;
        }
        System.out.println(left+" "+right+" "+head+" "+leftleg+" "+rightleg);

    }



}
