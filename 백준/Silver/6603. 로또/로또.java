import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,s,totals;
    static StringTokenizer st;
    static boolean[] check1;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            n = Integer.parseInt(st.nextToken());
            if(n == 0){
                break;
            }
            for(int i = 0; i<n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            List<Integer> lotto = new ArrayList<>();
            check1 = new boolean[n];
            DFS(lotto,0,0);
            System.out.println();
        }

    }

    private static void DFS(List<Integer> lotto,int idx,int start) {
        if(idx == 6){
            for (Integer lottos : lotto) {
                System.out.print(lottos+" ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i<n; i++){
            if(!check1[i]){
                check1[i] = true;
                lotto.add(list.get(i));
                DFS(lotto,idx+1,i+1);
                check1[i] = false;
                lotto.remove(lotto.size()-1);
            }
        }
    }


}
