import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max_total = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[7]; // 주사위 눈 1~6
            int[] dice = new int[4];

            for (int j = 0; j < 4; j++) {
                dice[j] = Integer.parseInt(st.nextToken());
                arr[dice[j]]++;
            }

            int total = 0;

            boolean handled = false;

            for (int j = 1; j <= 6; j++) {
                if (arr[j] == 4) {
                    total = 50000 + j * 5000;
                    handled = true;
                    break;
                } else if (arr[j] == 3) {
                    total = 10000 + j * 1000;
                    handled = true;
                    break;
                }
            }

            if (!handled) {
                int pairCount = 0;
                List<Integer> pairs = new ArrayList<>();
                for (int j = 1; j <= 6; j++) {
                    if (arr[j] == 2) {
                        pairCount++;
                        pairs.add(j);
                    }
                }

                if (pairCount == 2) {
                    // 두 쌍
                    total = 2000 + pairs.get(0) * 500 + pairs.get(1) * 500;
                } else if (pairCount == 1) {
                    // 한 쌍
                    for (int j = 1; j <= 6; j++) {
                        if (arr[j] == 2) {
                            total = 1000 + j * 100;
                            break;
                        }
                    }
                } else {
                    // 모두 다름
                    int max = 0;
                    for (int j = 1; j <= 6; j++) {
                        if (arr[j] == 1) {
                            max = Math.max(max, j);
                        }
                    }
                    total = max * 100;
                }
            }

            max_total = Math.max(max_total, total);
        }

        System.out.println(max_total);
    }
}
