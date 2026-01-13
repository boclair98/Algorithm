import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static Deque<Integer> dq = new ArrayDeque<>();
    static int max_size = 0;
    static int last_num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n -- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                dq.add(Integer.parseInt(st.nextToken()));
            }else if(a == 2){
                dq.poll();
            }
            if(max_size < dq.size()){
                max_size = dq.size();
                last_num = dq.peekLast();
            }
            if(max_size == dq.size()){
                if(last_num > dq.peekLast()){
                    last_num = dq.peekLast();
                }
            }
        }
        System.out.println(max_size+" "+last_num);

    }

}
