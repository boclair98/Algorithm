import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map1 = new HashMap<>(); // 색
    static Map<Integer, Integer> map2 = new HashMap<>(); // 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] word = br.readLine().split(" ");
            map1.put(word[0], map1.getOrDefault(word[0], 0) + 1);
            int v = Integer.parseInt(word[1]);
            map2.put(v, map2.getOrDefault(v, 0) + 1);
        }

        int total = 0;

        // 숫자 정렬
        List<Integer> list = new ArrayList<>(map2.keySet());
        Collections.sort(list);
        int maxCard = Collections.max(list);

        // 스트레이트 체크
        boolean straight = (list.size() == 5);
        if (straight) {
            for (int i = 0; i < 4; i++) {
                if (list.get(i) + 1 != list.get(i + 1)) {
                    straight = false;
                    break;
                }
            }
        }

        // 플러시 체크
        boolean flush = map1.size() == 1;

        // 1. 스트레이트 플러시
        if (flush && straight) {
            total = 900 + maxCard;
        }

        // 2. 포카드 / 풀하우스
        else if (map2.size() == 2) {
            int four = 0, three = 0, two = 0;

            for (int k : map2.keySet()) {
                if (map2.get(k) == 4) four = k;
                else if (map2.get(k) == 3) three = k;
                else if (map2.get(k) == 2) two = k;
            }

            if (four != 0) {
                total = 800 + four;              // 포카드
            } else {
                total = 700 + three * 10 + two;  // 풀하우스
            }
        }

        // 3. 플러시
        else if (flush) {
            total = 600 + maxCard;
        }

        // 4. 스트레이트
        else if (straight) {
            total = 500 + maxCard;
        }

        // 5. 트리플 / 투페어
        else if (map2.size() == 3) {
            int three = 0;
            List<Integer> pair = new ArrayList<>();

            for (int k : map2.keySet()) {
                if (map2.get(k) == 3) three = k;
                else if (map2.get(k) == 2) pair.add(k);
            }

            if (three != 0) {
                total = 400 + three; // 트리플
            } else {
                Collections.sort(pair, Collections.reverseOrder());
                total = 300 + pair.get(0) * 10 + pair.get(1); // 투페어
            }
        }

        // 6. 원페어
        else if (map2.size() == 4) {
            int pair = 0;
            for (int k : map2.keySet()) {
                if (map2.get(k) == 2) {
                    pair = k;
                    break;
                }
            }
            total = 200 + pair;
        }

        // 7. 하이카드
        else {
            total = 100 + maxCard;
        }

        System.out.println(total);
    }
}
