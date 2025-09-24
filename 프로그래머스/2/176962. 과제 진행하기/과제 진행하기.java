//과제는 시작하기로 한 시각이 되면 시작

import java.util.*;
class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        //과제 리스트로 변환
        Stack<String[]> list  = new Stack<>();
        for(int i = 0; i<plans.length; i++){
            change(plans,i,list);
        }
        
        //남은 과제 
        Stack<String[]> work  = new Stack<>();
        
        
        //시간별 정렬.
        list.sort((o1,o2) ->{
            int a = Integer.parseInt(o1[1]);
            int b = Integer.parseInt(o2[1]);
            return Integer.compare(a,b);
        });
        
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i)[0]+" "+list.get(i)[1]+" "+list.get(i)[2]);
        }
        
        // for(int i = 0; i<work.size(); i++){
        //     System.out.println(work.get(i)[0]+" "+work.get(i)[1]+" "+work.get(i)[2]);
        // }
        
        // 과제 시작
        for(int i = 0; i<list.size()-1; i++){
            String subject = list.get(i)[0];
            int now = Integer.parseInt(list.get(i)[1]);
            int next = Integer.parseInt(list.get(i)[2]);
            
            int nextnow = Integer.parseInt(list.get(i+1)[1]);
            
            if(now + next > nextnow){
                work.push(new String[]{subject, String.valueOf(now+next - nextnow)});
            }else{
                answer.add(subject);
                int free = nextnow - (next+now);
                while(!work.isEmpty() && free > 0){
                    String[] w = work.pop();
                    if(Integer.parseInt(w[1]) <=free){
                        free-=Integer.parseInt(w[1]);
                        answer.add(w[0]);
                    }else{
                        work.push(new String[]{w[0], String.valueOf(Integer.parseInt(w[1]) - free)});
                        free = 0;
                    }
                    
                }
            }
        }
        answer.add(list.get(list.size()-1)[0]);
        while(!work.isEmpty()){
            String[] s = work.pop();
            answer.add(s[0]);
        }
        return answer;
    }
    static void change(String[][] plans, int idx,List<String[]> list){
        String[] p = plans[idx];
        String a = p[0];
        String b = p[1];
        String c = p[2];
        String[] w = b.split(":");
        int time = Integer.parseInt(w[0]) *  60 + Integer.parseInt(w[1]);
        list.add(new String[]{a,String.valueOf(time),c});
        
    }
}