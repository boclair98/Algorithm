import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int cnt = Integer.parseInt(br.readLine());
            if(cnt == 0) break;
            int answer = 0;
            boolean[] sc = sosu(2*cnt);
            for(int i =cnt+1; i<=2*cnt; i++){
                if(sc[i]){
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
    static boolean[] sosu(int num){
        boolean[] check = new boolean[num+1];
        Arrays.fill(check,true);
        check[0] = check[1] = false;
        for(int i = 2; i*i<=num; i++){
            if(check[i]){
                for(int j = i*i; j<=num; j+=i){
                    check[j] = false;
                }
            }
        }
        return check;
    }

}
