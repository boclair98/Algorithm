import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]arr = new int[1001];
        boolean[] visietd = new boolean[1001];
        StringTokenizer st ;
        int max_depth = 0;
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
            max_depth = Math.max(max_depth,b);
            minIndex = Math.min(a,minIndex);
            maxIndex = Math.max(a,maxIndex);
        }
        int m_d = 0;
        int total = 0;
        for(int i = minIndex; i<=maxIndex; i++){
            m_d = Math.max(m_d,arr[i]);
            visietd[i] = true;
            total+=m_d;
            if(m_d == max_depth){
                break;
            }
        }

        int r_d = 0;
        for(int j = maxIndex; j>=minIndex; j--){
            r_d = Math.max(r_d,arr[j]);
            if(r_d == max_depth && visietd[j]){
                break;
            }
            total+=r_d;
            visietd[j] = true;

        }
        System.out.println(total);

    }
}