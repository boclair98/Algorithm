import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb  = new StringBuilder();
        for(int i = 0; i<n; i++){
            String[] word = br.readLine().split(" ");
            if(word[0].equals("add")){
                if(!set.contains(Integer.parseInt(word[1]))){
                    set.add(Integer.parseInt(word[1]));
                }
            }else if(word[0].equals("remove")){
                if(set.contains(Integer.parseInt(word[1]))){
                    set.remove(Integer.parseInt(word[1]));
                }
            }else if(word[0].equals("check")){
                if(set.contains(Integer.parseInt(word[1]))){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(word[0].equals("toggle")){
                if(set.contains(Integer.parseInt(word[1]))){
                    set.remove(Integer.parseInt(word[1]));
                }else{
                    set.add(Integer.parseInt(word[1]));
                }
            }else if(word[0].equals("all")){
                set.clear();
                for(int j = 1; j<=20; j++){
                    set.add(j);
                }
            }else if(word[0].equals("empty")){
                set.clear();
            }
        }
        System.out.println(sb);
    }
}