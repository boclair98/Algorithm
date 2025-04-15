class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int num1 = 0;
        int num2 = 0;
        int len = sizes.length;
        int[][] cm = new int[len][2];
        for (int i = 0; i<len; i++){
            if (sizes[i][1] > sizes[i][0]){
                cm[i][0] = sizes[i][1];
                cm[i][1] = sizes[i][0];
            }else{
                cm[i][0] = sizes[i][0];
                cm[i][1] = sizes[i][1];
            }
        }
        for(int i = 0; i<len; i++){
            num1 = Math.max(cm[i][0],num1);
            num2 = Math.max(cm[i][1],num2);
        }
        answer = num1 * num2;
        return answer;
    }
}