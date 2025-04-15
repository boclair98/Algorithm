class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                answer.append(" ");
                continue;
            }

            char base = Character.isUpperCase(ch) ? 'A' : 'a'; // 대문자 or 소문자 기준
            char newChar = (char) ((ch - base + n) % 26 + base); // 시저 암호 변환

            answer.append(newChar);
        }

        return answer.toString();
    }
}
