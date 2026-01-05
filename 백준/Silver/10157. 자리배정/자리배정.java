import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 가로
        int R = Integer.parseInt(st.nextToken()); // 세로
        int num = Integer.parseInt(br.readLine()); // 관객 번호

        // 배정 불가능한 경우 처리
        if (num > (long)C * R) {
            System.out.println(0);
            return;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] visited = new boolean[C][R];
        int sx = 0;
        int sy = 0;
        int count = 1;
        int idx = 0;

        visited[sx][sy] = true;

        while (count < num) {
            int nx = sx + dx[idx];
            int ny = sy + dy[idx];
            if (nx < 0 || nx >= C || ny < 0 || ny >= R || visited[nx][ny]) {
                idx = (idx + 1) % 4;
                nx = sx + dx[idx];
                ny = sy + dy[idx];
            }
            sx = nx;
            sy = ny;
            visited[sx][sy] = true;
            count++;
        }
        System.out.println((sx + 1) + " " + (sy + 1));
    }
}