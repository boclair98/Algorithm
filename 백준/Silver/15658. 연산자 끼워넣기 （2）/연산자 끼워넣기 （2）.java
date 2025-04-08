import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n,num1, num2;
    static int[] prefix;
    static StringTokenizer st;
    static ArrayList<Integer> arr ;
    static ArrayList<Integer> number ;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        number = new ArrayList<>();
        num1 = -Integer.MAX_VALUE;
        num2 = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            number.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        prefix = new int[4];
        visited = new boolean[4];
        arr = new ArrayList<>();
        for(int i = 0; i<4; i++){
            prefix[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0,number.get(0));
        System.out.println(num1);
        System.out.println(num2);
    }

    private static void DFS(int depth, int total) {
        if(depth == n-1){
            num1 = Math.max(num1,total);
            num2 = Math.min(num2,total);
            return;
        }
        for(int i = 0; i<4; i++){
            if(prefix[i] <=0){
                continue;
            }
            if(prefix[i] > 0){
                prefix[i] -- ;
                if(i == 0){
                    DFS(depth+1,total+number.get(depth+1));
                    prefix[i] ++;
                }
                if(i == 1){
                    DFS(depth+1,total-number.get(depth+1));
                    prefix[i] ++;
                }
                if(i == 2){
                    DFS(depth+1,total*number.get(depth+1));
                    prefix[i] ++;
                }
                if(i == 3){
                    DFS(depth+1,total/number.get(depth+1));
                    prefix[i] ++;
                }
            }

        }
    }
}

