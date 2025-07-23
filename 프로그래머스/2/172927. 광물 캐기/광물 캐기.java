import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;

    // 피로도 테이블
    int[][] fatigue = {
        {1, 1, 1},     // 다이아 곡괭이
        {5, 1, 1},     // 철 곡괭이
        {25, 5, 1}     // 돌 곡괭이
    };

    public int solution(int[] picks, String[] minerals) {
        dfs(0, 0, picks, minerals);
        return min;
    }

    void dfs(int idx, int totalPiro, int[] picks, String[] minerals) {
        if (idx >= minerals.length || Arrays.stream(picks).sum() == 0) {
            min = Math.min(min, totalPiro);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;

                int temp = 0;
                for (int j = idx; j < idx + 5 && j < minerals.length; j++) {
                    int m = getMineralIndex(minerals[j]);
                    temp += fatigue[i][m];
                }

                dfs(idx + 5, totalPiro + temp, picks, minerals);

                picks[i]++;  // 백트래킹
            }
        }
    }

    int getMineralIndex(String mineral) {
        switch (mineral) {
            case "diamond": return 0;
            case "iron": return 1;
            default: return 2;
        }
    }
}
