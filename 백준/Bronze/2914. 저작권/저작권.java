import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int tn = 0;
        int idx = 1;

        while (true) {
            int num = a * idx;
            if (Math.ceil((double) num / a) == b) {
                tn = num;
                break;
            }
            idx++;
            if (idx > 1_000_000) break; // 무한루프 방지
        }

        // ceil(tn/a) == b인 tn에서 하나씩 줄이면서
        while(true) {
            tn--;
            if(Math.ceil((double)  tn / a ) < b){
                break;
            }
        }

        System.out.println(++tn);
    }
}
