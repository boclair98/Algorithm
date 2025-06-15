class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0; i<4; i++){
            int nx = h + dx[i];
            int ny = w + dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(board[h][w].equals(board[nx][ny])){
                    answer++;
                }
            }
        }
        return answer;
    }
}