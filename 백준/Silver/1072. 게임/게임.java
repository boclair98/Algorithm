import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken()); // 총 게임 수
        long y = Long.parseLong(st.nextToken()); // 이긴 게임 수

        long tot = y * 100 / x; // 현재 승률
//        System.out.println(tot);

        long start = 1;
        long end = 1_000_000_000L;
        long ans = -1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cal = cal(x, y, mid);

            if (cal > tot) {
                ans = mid;      // 승률이 증가하는 최소 mid 후보
                end = mid - 1;  // 더 작은 mid도 확인
            } else {
                start = mid + 1; // 아직 승률 그대로 → 더 많이 해야 함
            }
        }

        System.out.println(ans);
    }

    private static long cal(long x, long y, long mid) {
        long total = x + mid; // 총 게임 수
        long win = y + mid;   // 이긴 게임 수
        return win * 100 / total; // 승률
    }
}
