import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n , m ,cnt,total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        int left = 0;
        int right = 1;
        while(right<m-1){
            if(word[left] == 'I' && word[right] =='O' && word[right+1] =='I'){
                cnt++;
                if(cnt == n){
                    total++;
                    cnt--;
                }
                left = right+1;
                right = left+1;
            }else{
                cnt = 0;
                left++;
                right = left + 1;
            }
        }
        System.out.println(total);
    }
}
