import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(ans);

    }

    private static void dfs(int index,int idx) {
        if(index == n / 2){
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if(!list.contains(i)){
                    list2.add(i);
                }
            }
//            System.out.println(list);
//            System.out.println(list2);
            int total = 0;
            int total2 = 0;
            for(int i = 0; i<list.size(); i++){
                int x = list.get(i);
                for(int j = 0; j<list.size(); j++){
                    int y = list.get(j);
                    if(i !=j){
                        total+=map[x][y];
                    }
                }
            }
            for(int i = 0; i<list2.size(); i++){
                int x = list2.get(i);
                for(int j = 0; j<list2.size(); j++){
                    int y = list2.get(j);
                    if(i !=j){
                        total2+=map[x][y];
                    }
                }
            }
//            System.out.println(total);
//            System.out.println(total2);
            ans = Math.min(ans,Math.abs(total-total2));
            return;

        }
        for(int i = idx; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                dfs(index+1,i+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }


}
