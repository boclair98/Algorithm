import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static int n ;
    static List<Integer> num = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        backTracking(0);
    }

    private static void backTracking(int depth) {
        if(depth == n){
            for (Integer i : num) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                num.add(i+1);
                backTracking(depth+1);
                visited[i] = false;
                num.remove(num.size()-1);
            }
        }
    }


}