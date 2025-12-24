import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String s;
    static int count = 0;
    static int[] ch = new int[26];

    static void recur(int idx, int prev){
        if(idx == s.length()){
            count++;
            return;
        }
        for(int i = 0; i<26; i++){
            if(ch[i] == 0) continue;
            if(i == prev) continue;
            ch[i]-=1;
            recur(idx+1,i);
            ch[i]+=1;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i = 0; i<s.length(); i++){
            ch[s.charAt(i) -'a']++;
        }
        recur(0,-1);
        System.out.println(count);

    }
}