class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        int num = 0;
        for(int i = 0; i<signs.length; i++){
            if(signs[i]){
                num = num + absolutes[i];
            }else{
                num = num - absolutes[i];
            }
        }
        return num;
    }
}