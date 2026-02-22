import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String word1;
    static String word2;
    static int n1,n2;
    static int[][] dp = new int[4050][4050];
    static int max_val = 0;
    static int recur(int idx,int idx2){
        if(idx == n1 || idx2 == n2) return 0;
        if(dp[idx][idx2] != -1) return dp[idx][idx2];
        int ans = 0;
        if(word1.charAt(idx) == word2.charAt(idx2)){
            ans = Math.max(ans,recur(idx+1,idx2+1)+1);
        }
        return dp[idx][idx2] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word1 = br.readLine();
        word2 = br.readLine();
        n1 = word1.length();
        n2 = word2.length();
        for(int i = 0 ; i < 4050; i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0; i <n1; i++){
            for(int j = 0; j <n2; j++){
                max_val = Math.max(max_val,recur(i,j));
            }
        }
        System.out.println(max_val);
    }
}
