class Solution {
    public int[] solution(long n) {
        
        String num = String.valueOf(n);
        int[] answer =new int[num.length()];
        
        System.out.println(num);
        for(int i = 0; i<num.length(); i++){
            answer[num.length()-1-i] = (int) ((1)*(num.charAt(i)-'0'));
        }
        return answer;
    }
}