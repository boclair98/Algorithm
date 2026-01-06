import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int max_val = 0;
        String ans = "";
        List<String> list = new ArrayList<>();
        for(String word : map.keySet()){
            max_val = Math.max(max_val, map.get(word));
        }
        for(String word : map.keySet()){
            if(map.get(word) == max_val){
                list.add(word);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }

}