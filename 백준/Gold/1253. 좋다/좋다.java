import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            long target = arr[i];
            int start = 0;
            int end = n - 1;

            while (start < end) {
                long sum = arr[start] + arr[end];

                if (sum == target) {
                    // 자기 자신을 사용하지 않도록 체크
                    if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    } else {
                        answer++;
                        break;
                    }
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(answer);
    }
}
