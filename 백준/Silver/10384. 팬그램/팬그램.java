import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static Map<Character,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i<=n; i++){
            map = new HashMap<>();
            String word = br.readLine();
            for(int j = 0; j < word.length(); j++){
                if((word.charAt(j)>='a' && word.charAt(j)<='z') || (word.charAt(j)>='A' && word
                        .charAt(j)<='Z')){
                    map.put(Character.toLowerCase(word.charAt(j)),map.getOrDefault(Character.toLowerCase(word.charAt(j)),0)+1);
                }
            }
            if(map.size()<26){
                System.out.println("Case "+(i)+": Not a pangram");
            }else{
                int cnt = Integer.MAX_VALUE;
                for(int value:map.values()){
                    cnt = Math.min(cnt,value);
                }
                if(cnt == 0){
                    System.out.println("Case "+(i)+": Not a pangram");
                }else if(cnt == 1){
                    System.out.println("Case "+(i)+": Pangram!");
                }else if(cnt == 2){
                    System.out.println("Case "+(i)+": Double pangram!!");
                }else{
                    System.out.println("Case "+(i)+": Triple pangram!!!");
                }
            }
        }

    }

}

