import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){

            String[] word = br.readLine().split(" ");
            boolean[] visited = new boolean[word.length];
            while(true){
                String w = br.readLine();
                if(w.equals("what does the fox say?")) break;
                String[] words = w.split(" ");
                for(int j = 0; j < word.length; j++){
                    if(word[j].equals(words[2])){
                        visited[j] = true;
                    }
                }
            }
            for(int i = 0; i < visited.length; i++){
                if(!visited[i]){
                    sb.append(word[i]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}

