import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        Arrays.fill(arr,-1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        arr[n] = 0;
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == m){
                System.out.println(arr[cur]);
                return;
            }
            int[] moves ={cur-1, cur+1, cur*2};
            for(int s:moves){
                if(s>=0 && s<=100000 && arr[s] == -1){
                    q.add(s);
                    arr[s] = arr[cur] + 1;
                }
            }
        }




    }


}
