import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            q.offer(new int[]{num,0});
            set.add(num);
        }
        long result = 0;
        long count = 0;
        int[] dir = {-1,1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int dist = cur[1];
            for(int i = 0; i<2; i++) {
                int nx = now + dir[i];
                if(!set.contains(nx)){
                    count++;
                    q.add(new int[]{nx,dist+1});
                    set.add(nx);
                    result+=dist+1;
                    if(count == k){
                        System.out.println(result);
                        return;
                    }
                }
            }

        }

    }

}

