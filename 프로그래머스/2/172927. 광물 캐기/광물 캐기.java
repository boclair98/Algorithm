import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    int totalPicks;
    int[][] fatigue = {
        {1, 1, 1},     // 다이아곡괭이
        {5, 1, 1},     // 철곡괭이
        {25, 5, 1}     // 돌곡괭이
    };
    
    public int solution(int[] picks, String[] minerals) {
        totalPicks = picks[0] + picks[1] + picks[2];
        dfs(picks, minerals, 0, 0);
        return min;
    }

    void dfs(int[] picks, String[] minerals, int depth, int totalFatigue) {
        // 5개씩만 캐니까 광물 초과 시 종료
        if (depth == totalPicks || depth * 5 >= minerals.length) {
            min = Math.min(min, totalFatigue);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;

                int fatigueSum = 0;
                for (int j = depth * 5; j < Math.min(minerals.length, depth * 5 + 5); j++) {
                    String mineral = minerals[j];
                    int m = mineral.equals("diamond") ? 0 : mineral.equals("iron") ? 1 : 2;
                    fatigueSum += fatigue[i][m];
                }

                dfs(picks, minerals, depth + 1, totalFatigue + fatigueSum);
                picks[i]++; // 백트래킹
            }
        }
    }
}
