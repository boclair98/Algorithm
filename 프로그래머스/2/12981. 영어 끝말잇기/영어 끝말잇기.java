import java.util.*;

class Solution {
    public List<Integer> solution(int n, String[] words) {
        List<Integer> result = new ArrayList<>();
        Set<String> usedWords = new HashSet<>();

        usedWords.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String current = words[i];
            if (usedWords.contains(current) || current.charAt(0) != prev.charAt(prev.length() - 1)) {
                int person = (i % n) + 1;
                int turn = (i / n) + 1;
                result.add(person);
                result.add(turn);
                return result;
            }
            usedWords.add(current);
        }

        // 모든 사람이 규칙을 잘 지킨 경우
        result.add(0);
        result.add(0);
        return result;
    }
}
