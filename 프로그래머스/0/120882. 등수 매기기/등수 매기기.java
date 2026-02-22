class Solution {
    public int[] solution(int[][] score) {
        int[] rank = new int[score.length];
        int[] answer = new int[score.length];
        for(int i = 0; i < score.length; i++){
            answer[i] = score[i][0] + score[i][1];
        }
        for(int i = 0 ; i < score.length; i++){
            int ranking = 1;
            for(int j = 0 ; j < score.length; j++){
                if(answer[i] < answer[j]){
                    ranking++;
                }
            }
            rank[i] = ranking;
        }
        return rank;
    }
}