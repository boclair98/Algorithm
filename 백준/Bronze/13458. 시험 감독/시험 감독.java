import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//사과를 먹으면 뱀의 길이가 늘어남

//종료 -> 뱀이 기어다니다가 벽 또는 자기 자신의 몸과 부딪히면 게임 끝.

//시작 -> 뱀은 0,0부터 시작을하고 뱀의 길이는 1
//     -> 처음은 오른쪽으로 향한다.

public class Main {

    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long count = 0;
        for(int i = 0; i<n; i++){
            arr[i] -=b;
            count++;
            if(arr[i] > 0){
                count+=(arr[i] / c);
                if(arr[i]%c > 0){
                    count++;
                }
            }

        }


        System.out.println(count);

    }



}

