class Solution {
    public Integer solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        Long num = Long.parseLong(p);
        for (int i = 0; i<=t.length()-len; i++){
            Long number = Long.parseLong(t.substring(i,i+len));
            System.out.println(number);
            if(num >= number){
                answer++;
            }
        }
        return answer;
    }
}