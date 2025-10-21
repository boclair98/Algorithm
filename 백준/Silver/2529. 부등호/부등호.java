import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visited = new boolean[10];
    static List<Integer> list = new ArrayList<>();
    static char[] arr;
    static String min = "";
    static String max = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        String line = br.readLine().replace(" ", ""); // 공백 있든 없든 처리
        arr = line.toCharArray();

        back(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void back(int idx) {
        if (idx == n + 1) {
            // 완성된 수 문자열 만들기
            StringBuilder sb = new StringBuilder();
            for (int x : list) sb.append(x);
            String num = sb.toString();

            if (min.equals("") || num.compareTo(min) < 0) min = num;
            if (max.equals("") || num.compareTo(max) > 0) max = num;
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (visited[d]) continue;

            // 가지치기: 이전 숫자와 현재 숫자 비교로 바로 위배하면 건너뛰기
            if (idx > 0) {
                int prev = list.get(idx - 1);
                if (arr[idx - 1] == '<' && !(prev < d)) continue;
                if (arr[idx - 1] == '>' && !(prev > d)) continue;
            }

            visited[d] = true;
            list.add(d);
            back(idx + 1);
            list.remove(list.size() - 1);
            visited[d] = false;
        }
    }
}
