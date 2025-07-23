import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static StringTokenizer st;
    static boolean[] visited;
    static List<List<Integer>> list;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[n+1];
        for(int i = 0; i<n+1; i++){
            list.add(new ArrayList<>());
        }
//        System.out.println(list);
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            list.get(second).add(first);
        }
        visited[1] = true;
        DFS(1,0);
//        System.out.println(list);
//        System.out.println(total);
        for(int i = 2; i<n+1; i++){
            if(visited[i]){
                total++;
            }
        }
        System.out.println(total);
    }


    private static void DFS(int number,int idx) {
        if(idx == 2){
            return;
        }

        for(int num : list.get(number)){
            visited[num] = true;
            DFS(num,idx+1);

            }
        }


    }

