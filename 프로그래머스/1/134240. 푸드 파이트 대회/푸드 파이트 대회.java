class Solution {
    public String solution(int[] food) {
        String answer = "";
        String member1 ="";
        String member2 ="";
        int n = food.length;
        for(int i = 1; i<n; i++){
            if(food[i]>=2){
                for(int j = 0; j<food[i] / 2; j++){
                    member1+=Integer.toString(i);
                    member2+=Integer.toString(i);
                }
            }
        }
        StringBuffer str = new StringBuffer(member2);
        member1+="0";
        answer = member1 + str.reverse().toString();
        return answer;
    }
}