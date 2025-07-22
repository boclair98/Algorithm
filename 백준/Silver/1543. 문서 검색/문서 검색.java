import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();
        int n = word1.length;
        int m = word2.length;
        int idx = 0;
        int total = 0;
        while(idx <= n - m){
            boolean flag = true;
            for(int i = 0; i<m; i++){
                if(word1[idx+i] != word2[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                idx+=m;
                total++;
            }else{
                idx++;
            }
        }
        System.out.println(total);
    }
}
