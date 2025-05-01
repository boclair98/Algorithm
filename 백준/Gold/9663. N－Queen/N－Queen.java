import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,total;
    static StringTokenizer st;
    static boolean[] check1;
    static boolean[] check2;
    static boolean[] check3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check1 = new boolean[40];
        check2 = new boolean[40];
        check3 = new boolean[40];
        DFS(0);
        System.out.println(total);
    }

    private static void DFS(int idx) {
        if(idx == n){
            total++;
            return;
        }
        for(int i = 0; i<n ; i++){
            if(check1[i] || check2[i+idx] || check3[idx-i+n+1]){
                continue;
            }
            check1[i] = true;
            check2[i+idx] = true;
            check3[idx-i+n+1] = true;
            DFS(idx+1);
            check1[i] = false;
            check2[i+idx] = false;
            check3[idx-i+n+1] = false;
        }
    }
}
