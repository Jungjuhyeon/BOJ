import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,Integer> map = new HashMap<>();
        Map<String,HashMap<Integer,Integer>> music = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            map.put(genre, map.getOrDefault(genre, 0) + play);

            HashMap<Integer, Integer> songMap = music.getOrDefault(genre, new HashMap<>());
            songMap.put(i, play);
            music.put(genre, songMap);
        }
        
        List<String> sortedGenres = new ArrayList<>(map.keySet());
        sortedGenres.sort((a, b) -> map.get(b) - map.get(a)); // ✅ 변수명 수정
        
        List<Integer> answer = new ArrayList<>();
        
              // 4. 각 장르에 대해 재생 수 내림차순으로 노래 정렬 후 상위 2개 선택
        for (String genre : sortedGenres) {
            HashMap<Integer, Integer> songs = music.get(genre);

            List<Map.Entry<Integer, Integer>> sortedSongs = new ArrayList<>(songs.entrySet());
            sortedSongs.sort((a, b) -> {
                if (b.getValue().equals(a.getValue())) {
                    return a.getKey() - b.getKey(); // 재생 수 같으면 인덱스 오름차순
                } else {
                    return b.getValue() - a.getValue(); // 재생 수 내림차순
                }
            });

            // 상위 2개만 answer에 담기
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : sortedSongs) {
                answer.add(entry.getKey());
                count++;
                if (count == 2) break;
            }
        }

        // 리스트를 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();

        
        
        
    }
}