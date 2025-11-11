import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int start ,end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (start<=end){
            List<Integer> s = si(start++);
            boolean[] sosu = check(s.size());
            if(sosu[s.size()]){
                answer++;
            }
        }
        System.out.println(answer);
    }
    static List<Integer> si(int num){
        List<Integer> list = new ArrayList<>();
        for(int i =2; i*i<=num; i++){
            while(num%i ==0){
                list.add(i);
                num = num / i;
            }
        }
        if(num > 1){
            list.add(num);
        }
        return list;
    }

    static boolean[] check(int num){
        boolean[] vi = new boolean[num+1];
        Arrays.fill(vi,true);
        vi[0] = vi[1] = false;
        for(int i =2; i*i<=num; i++){
            if(vi[i]){
                for(int j = i*i; j<=num; j+=i){
                    vi[j] = false;
                }
            }
        }
        return vi;
    }


}
