

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int s = 0; s<test; s++){
            boolean rever = false;
            String word = br.readLine();
            Deque<Integer> q = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());
            String number = br.readLine();
            number = number.substring(1, number.length()-1);
            String[] num = number.split(",");
            for(int i = 0; i<n; i++){
                q.offer(Integer.parseInt(num[i]));
            }
            Change(q,word);
        }
        System.out.println(sb.toString());
    }

    private static void Change(Deque<Integer> q, String word) {
        boolean check = true;
        for(int i = 0; i< word.length(); i++){
            if(word.charAt(i) == 'R'){
                check = !check;
                continue;
            }

            if(check){
                if(q.poll() == null){
                    sb.append("error\n");
                    return;
                }
            }else{
                if(q.pollLast() == null){
                    sb.append("error\n");
                    return;
                }
            }
        }
        Making(q,check);

    }

    private static void Making(Deque<Integer> q, boolean check) {

        sb.append('[');
        if(q.size() > 0){
            if(check){
                sb.append(q.poll());
                while(!q.isEmpty()){
                    sb.append(",").append(q.pollFirst());
                }
            }else{
                sb.append(q.pollLast());
                while(!q.isEmpty()){
                    sb.append(",").append(q.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }

}
