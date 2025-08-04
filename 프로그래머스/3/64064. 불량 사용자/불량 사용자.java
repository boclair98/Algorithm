//불량 사용자 프로도에게 전달
//아이디 중 일부 문자를 * 가림.
//가리고자 하는 문자 하나에 * 문자 하나 사용/
//여러 조합 중 제재 아이디에 맞는 조합 찾기

//중복 처리 set으로 변환.
// a b c , c a b , c b a 이런식으로 처리 하기 -> 실질적으로는 같음.
// abc abc abc
import java.util.*;
class Solution {
    static boolean[] visited;
    static int n, m;
    
    //제제 아이디
    static List<String> name = new ArrayList<>();
    
    //중복제외한 최종 아이디.
    static Set<String> user = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        m = banned_id.length;
        
        //방문 처리
        visited = new boolean[n];
        
        //조합 완전 탐색.
        DFS(0,user_id,banned_id);
        return user.size();
    }
    public static void DFS(int index, String[] user_id, String[] banned_id){
        
        if(index == m){
            // System.out.println(name);
            
            List<String> sorted = new ArrayList<>(name);
            Collections.sort(sorted);
            // System.out.println(sorted);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<m; i++){
                sb.append(sorted.get(i)).append("");
            }
            user.add(sb.toString());
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                String names1 = user_id[i];
                String names2 = banned_id[index];
                
                if(checkName(names1,names2)){
                    visited[i] = true;
                    name.add(names1);
                    DFS(index+1,user_id,banned_id);
                    name.remove(name.size()-1);
                    visited[i] = false;
                    }
                }
            }
        }
    
    public static boolean checkName(String name1, String name2){
        if(name1.length()!= name2.length()) return false;
        for(int i = 0; i<name1.length(); i++){
            if(name2.charAt(i) =='*') continue;
            if(name2.charAt(i)!=name1.charAt(i)) return false;
        }
        return true;
    }
    
}