import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            long max = 0;
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
//            Collections.sort(list);
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
            for(int i = 0; i< list.size(); i++){
                for(int j = 0; j<list.size(); j++){
                    if(i == j) continue;
                    max = Math.max(max,gcd(list.get(i),list.get(j)));
                }
            }
            System.out.println(max);

        }

    }
    static long gcd(long a, long b){
        while(b!=0){
            long temp = a % b;
            a= b;
            b = temp;
        }
        return a;
    }
}
