import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] house;
    static List<Integer> list = new ArrayList<>();
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        house = new int[n];
        num = new int[n];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            num[i] = i+1;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            house[i] = Integer.parseInt(st.nextToken());
        }
        back(0);
    }

    private static void back(int depth) {
        if(depth == n){
            boolean flag = true;
//            System.out.println(list);
            for(int i = 0; i<n; i++){
                int count = list.get(i);
                int total = house[count-1];
//                System.out.println(count+" "+total);
                int cnt = 0;
                for(int j = 0; j<i; j++){
                    if(count < list.get(j)){
                        cnt++;
                    }
                }
                if(cnt != total){
                    flag = false;
                }
            }
            if(flag){
                for (Integer i : list) {
                    System.out.print(i+" ");
                }
            }
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(num[i]);
                back(depth+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
