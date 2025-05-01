import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l,c;
    static boolean[] visited;
    static List<Character> list = new ArrayList<>();
    static List<Character> alpha = new ArrayList<>();
    static Character[] alphaCheck = {'a','e','i','o','u'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visited = new boolean[c];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<c; i++){
            list.add(st.nextToken().charAt(0));
        }
        Collections.sort(list);
        DFS(0,0);
    }
    static boolean check(Character c){
        for(int i = 0; i<5; i++){
            if(alphaCheck[i] == c){
                return true;
            }
        }
        return false;
    }
    private static void DFS(int idx,int start) {
        if(idx == l){
            int m = 0;
            int j = 0;
            for (Character b : alpha) {
                if(check(b)){
                    m++;
                }else{
                    j++;
                }
            }
            if(m>=1 && j>=2){
                for (Character c : alpha) {
                    System.out.print(c+"");
                }
                System.out.println();
            }
            return;
        }
        for(int i = start; i<c; i++){
            if(!visited[i]){
                visited[i] = true;
                alpha.add(list.get(i));
                DFS(idx+1,i+1);
                visited[i] = false;
                alpha.remove(alpha.size()-1);
            }
        }

    }


}
