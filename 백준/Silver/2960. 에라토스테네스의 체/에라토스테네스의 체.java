import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    static boolean sosu(int num){
        if(num < 2) return false;
        for(int i = 2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 2; i<=n; i++){
            list.add(i);
        }
        for(int i = 0; i<list.size(); i++){
            if(sosu(list.get(i))) {
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j) % list.get(i) == 0){
                        if(!answer.contains(list.get(j))){
                            answer.add(list.get(j));
                        }
                    }
                }
            }
        }
        System.out.println(answer.get(m-1));
    }
}
