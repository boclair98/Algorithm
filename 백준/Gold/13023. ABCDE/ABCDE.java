import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m,cnt;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static boolean found = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i = 0 ; i < n; i++){
            dfs(i,0);
        }
        if(found) System.out.println(1);
        else System.out.println(0);
    }
    static void dfs(int num,int index){
        if(index == 4){
            found = true;
            return;
        }
        visited[num] = true;
        for(int nums : list.get(num)){
            if(!visited[nums]){
                dfs(nums,index+1);
            }
            if(found) return;
        }
        visited[num] = false;
    }

}
