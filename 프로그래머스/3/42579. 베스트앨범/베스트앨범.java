//속한 노래가 많이 재생된 장르를 먼저 수록합니다
//장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
import java.util.*;
class Solution {
    static class Music{
        int index;
        int time;
        public Music(int index, int time){
            this.index = index;
            this.time = time;
        }
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int n = genres.length;
        //장르별 재생된 노래 횟수 
        Map<String,Integer> play = new HashMap<>();
        for(int i = 0; i<n; i++){
            play.put(genres[i],play.getOrDefault(genres[i],0)+plays[i]);
        }
        // System.out.println(play);
        List<String> music = new ArrayList<>();
        for(String name : play.keySet()){
            music.add(name);
        }
        music.sort((o1,o2) ->play.get(o2) - play.get(o1));
        // System.out.println(music);
        
        for(int i = 0; i<music.size(); i++){
            String genre = music.get(i);
            List<Music> musics = new ArrayList<>();
            for(int j = 0; j<n; j++){
                if(genres[j].equals(genre)){
                    musics.add(new Music(j,plays[j]));
                }
            }
            musics.sort((m1,m2) ->{
                        if(m1.time!=m2.time) return m2.time - m1.time;
                        return m1.index - m2.index;
            });
            
            if(musics.size() != 0){
                answer.add(musics.get(0).index);
            }
            if(musics.size() > 1){
                answer.add(musics.get(1).index);
            }
        }
        
        return answer;
    }
}