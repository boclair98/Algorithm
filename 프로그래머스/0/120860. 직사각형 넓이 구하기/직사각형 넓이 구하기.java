class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int max_x = -Integer.MAX_VALUE;
        int max_y = -Integer.MAX_VALUE;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        for(int i = 0; i<4; i++){
            max_x = Math.max(max_x,dots[i][0]);
            max_y = Math.max(max_y,dots[i][1]);
            min_x = Math.min(min_x,dots[i][0]);
            min_y = Math.min(min_y,dots[i][1]);
        }
        
        return (max_x - min_x) *(max_y - min_y);
    }
}