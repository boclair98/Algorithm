import org.w3c.dom.Node;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n, number1,number2;
    static Queue<String[]> q ;
    static List<Character> alpha;
    static StringTokenizer st;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            number1 = Integer.parseInt(st.nextToken());
            number2 = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            q = new LinkedList<>();
            q.add(new String[]{String.valueOf(number1),""});
            sb = new StringBuilder();

            while(!q.isEmpty()){
                String[] cur = q.poll();
                int a = Integer.parseInt(cur[0]);
                String b = cur[1];
                if(a == number2){
                    sb.append(b);
                    break;
                }
                int first = a * 2 % 10000;
                if(!visited[first]){
                    visited[first] = true;
                    q.add(new String[]{String.valueOf(first),b+"D"});
                }
                int second = a  - 1;
                if(second == -1){
                    second = 9999;
                }
                if(!visited[second]){
                    visited[second] = true;
                    q.add(new String[]{String.valueOf(second),b+"S"});
                }

                int third = a % 1000 * 10 + a / 1000;
                if(!visited[third]){
                    visited[third] = true;

                    q.add(new String[]{String.valueOf(third),b+"L"});
                }
                int four = a % 10 * 1000 + a / 10;
                if(!visited[four]){
                    visited[four] = true;
                    q.add(new String[]{String.valueOf(four),b+"R"});
                }

            }
            System.out.println(sb.toString());

        }

    }
}





