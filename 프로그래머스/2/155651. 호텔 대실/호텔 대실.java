import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

        List<Integer> time = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
            int start = time_change(book_time[i][0]);
            int finish = time_change(book_time[i][1]) + 10;

            boolean assigned = false;
            for (int j = 0; j < time.size(); j++) {
                if (start >= time.get(j)) {
                    time.set(j, finish);  // 기존 방 재사용!
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                time.add(finish);  // 새로운 방 추가
            }
        }

        return time.size();  // 필요한 방 개수
    }

    public static int time_change(String t) {
        String[] num = t.split(":");
        return Integer.parseInt(num[0]) * 60 + Integer.parseInt(num[1]);
    }
}
