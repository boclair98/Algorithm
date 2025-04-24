import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        char[] alpha = {'q','u','a','c','k'};
        if(word[0] !='q' || word.length % 5 !=0){
            System.out.println(-1);
            return;
        }
        int idx = 0;
        int cnt = 0;
        boolean[] visited = new boolean[word.length];
        for(int i = 0; i<word.length; i++){
            List<Character> bet = new ArrayList<>();
            for (int j = i ; j < word.length; j++) {
                if(!visited[j] && word[j] == alpha[idx]){
                    visited[j] = true;
                    idx++;
                    if(idx == 5){
                        idx = 0;
                    }
                    bet.add(word[j]);
                }
            }
            if(bet.size()>0) {
                if (bet.get(bet.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                cnt++;
            }


        }
        System.out.println(cnt);

    }
}