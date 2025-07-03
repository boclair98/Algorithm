import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> box = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        boolean[] visited = new boolean[n];

        DFS(0,n,k,list,visited);
        System.out.println(set.size());
    }

    private static void DFS(int idx, int n, int k, List<Integer> list, boolean[] visited) {
        if(idx == k){
            StringBuilder sb = new StringBuilder();
            for (Integer number : box) {
                sb.append(number);
            }
            int num = Integer.parseInt(sb.toString());
            set.add(num);
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                box.add(list.get(i));
                DFS(idx+1,n,k,list,visited);
                visited[i] = false;
                box.remove(box.size()-1);
            }
        }
    }
}
