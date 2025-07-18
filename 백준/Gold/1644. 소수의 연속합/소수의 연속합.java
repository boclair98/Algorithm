import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] sosu = new boolean[4000001];
        for(int i = 2; i*i<=n; i++){
            if(!sosu[i]){
                for(int j = i*i; j<=n; j+=i){
                    sosu[j] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i<=n; i++){
            if(!sosu[i]){
                list.add(i);
            }
        }
        int start = 0, end = 0;
        int total = 0,count =0;
        int last = list.size();
        while(end < last){
            total+=list.get(end);
            while(total > n){
                total-=list.get(start);
                start++;
            }
            if(total == n){
                count++;
            }
            end++;
        }
        System.out.println(count);
    }
}