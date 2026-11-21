import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prime = new boolean[1000001];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for(int i = 2; i*i<=1000000; i++){
            if(prime[i]){
                for(int j = i*i; j<=1000000; j+=i){
                    prime[j] = false;
                }
            }
        }
        for(int i = 0; i < n; i++){
            int cnt = 0;
            int number = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int j = 2; j<=number; j++){
                if(prime[j]){
                    list.add(j);
                }
            }
            int left = 0;
            int right = list.size()-1;
            while(left<=right){
                int num = list.get(left) + list.get(right);
                if(num == number){
                    cnt++;
                    left++;
                    right--;
                }else if(num < number){
                    left++;
                }else{
                    right--;
                }

            }
            System.out.println(cnt);
        }

    }
}
