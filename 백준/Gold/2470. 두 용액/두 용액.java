import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // n은 int로 충분
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        long ans1 = 0;
        long ans2 = 0;
        long min_val = Long.MAX_VALUE;

        while (left < right) {
            long sum = arr[left] + arr[right];
            long absSum = Math.abs(sum);

            if (absSum < min_val) {
                min_val = absSum;
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
