import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        List<Long> number = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        while(st.hasMoreTokens() && count < n){
            sb = new StringBuilder(st.nextToken()).reverse();
            number.add(Long.parseLong(sb.toString()));
            count++;
        }
        while(count < n){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens() && count < n){
                sb = new StringBuilder(st.nextToken()).reverse();
                number.add(Long.parseLong(sb.toString()));
                count++;
            }
        }
        Collections.sort(number);
//        System.out.println(number);

        for (Long num : number) {
            System.out.println(num);
        }
    }

}
