import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n , m;
    static int[][] arr;
    private static int total;
    private static boolean[] visited;
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][3];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
//            System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
        }
        DFS(0,0);
        System.out.println(total);

    }

    static void DFS(int idx, int sum) {
        if(sum > m) return;
        if(sum == m) {
            total++;
            return;
        }
        if(idx == n) return;

        // 1) 현재 수업 선택 안함
        DFS(idx + 1, sum);

        int w = arr[idx][0];
        int s = arr[idx][1];
        int e = arr[idx][2];

        if(w == 5) return; // 금요일 수업 제외

        // 시간 겹침 체크
        for(int[] course : list){
            if(course[0] == w && !(course[2] < s || course[1] > e)) {
                return; // 시간 겹침
            }
        }

        list.add(arr[idx]);
        DFS(idx + 1, sum + (e - s + 1));
        list.remove(list.size() - 1);
    }
}