class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int x = brown / 2 + 1;
        int y = 1;
        while (x>=y){
            if( (x -2) * (y - 2) == yellow){
                answer[0] = x;
                answer[1] = y;
                break;
            } 
            x--;
            y++;
        }
        return answer;
    }
}