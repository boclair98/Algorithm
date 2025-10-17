import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        String word = br.readLine();
        char[] arr = new char[word.length()];
        boolean[] visited = new boolean[word.length()];
        for(int i = 0; i<word.length(); i++){
            arr[i] = word.charAt(i);
        }

        for(int i = 0; i<word.length(); i++){
            if(arr[i] == 'P'){
                for(int j = Math.max(0,i-k); j<=Math.min(n-1,i+k); j++){
                    if(!visited[j] && arr[j] =='H'){
                        visited[j] = true;
                        break;
                    }
                }

            }
        }
        int answer = 0;

        for(int i = 0; i<word.length(); i++){
            if(visited[i]) answer++;
        }


        System.out.println(answer);
    }
}
