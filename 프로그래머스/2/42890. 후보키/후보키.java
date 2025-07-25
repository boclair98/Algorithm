import java.util.*;
//유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
//최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.
//즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다.
//여러 조합으로 후보키 만든다.

class Solution {
    static Set<String> set = new HashSet<>();
    static List<Set<Integer>>key = new ArrayList<>();
    static boolean[] visited;
    public int solution(String[][] relation) {
        int answer = 0;
        int idx = 0 ;
        int n = relation[0].length;
        visited = new boolean[n];
        for(int i = 1; i<=n; i++){
            dfs(0,0,i,relation);
        }
        return key.size();
    }

    public static void dfs(int depth,int start, int end, String[][] relation){
        if(depth == end){
            
            //리스트안에 어떤 조합으로 진행할지 선정.
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<relation[0].length; i++){
                if(visited[i]) list.add(i); // 0
            }
            
            
            //유일성 검사. [0,1,2] 이런식으로 있으면 학번 이름 전공을 문자열로 만들어줌.
            // 문자열로 만든 후 set에 그 문자열이 있으면 유일성 위반
            // 없으면 유일성 성립.
            
            Set<String> set = new HashSet<>();
            for(int i = 0; i<relation.length; i++){
                StringBuilder sb = new StringBuilder();
                //01 02
                for(int col : list){
                    sb.append(relation[i][col]).append("_"); 
                }
                if(set.contains(sb.toString())) return;
                    set.add(sb.toString());
            }
            
            System.out.println(set);
            //최소성 검사. // 질문하기 이용 
            // 키안에 [1]이 있을 경우 [1,2] 혹은 [1,3] , [1,2,3] 이런게 성립 x
            
            for(Set<Integer> keys : key){
                if(list.containsAll(keys)) return; 
            }
            // System.out.println(key);
            
            //유일성과 최소성이 다 성립이 되면 추가
            key.add(new HashSet<>(list));
           
            return;
        
        }
        for(int i = start; i<relation[0].length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,i+1,end,relation);
                visited[i] = false;
            }
        }   
    }
}