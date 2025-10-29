import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String,Map<Integer,Integer>> map = new HashMap<>();
        Map<String,Integer> totalMap = new HashMap();
        
        // 1. 장르별 노래 저장
        for (int i = 0; i < genres.length; i++) {
            map.putIfAbsent(genres[i], new HashMap<>());
            map.get(genres[i]).put(i, plays[i]);
            totalMap.put(genres[i],totalMap.getOrDefault(genres[i],0)+plays[i]);
        }
        
        List<String> list = new ArrayList<>(totalMap.keySet());
        list.sort((a, b) -> Integer.compare(totalMap.get(b), totalMap.get(a)));
                
        List<Integer> result = new ArrayList<>();
        for(String s : list){
            List<Map.Entry<Integer,Integer>> songs = new ArrayList<>(map.get(s).entrySet());
            
            songs.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue()))
                    return Integer.compare(b.getValue(), a.getValue()); // 재생 수 내림차순
                else
                    return Integer.compare(a.getKey(),b.getKey());
            });

            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i).getKey());
            }
        }

        // 5. 배열 변환
        return result.stream().mapToInt(i -> i).toArray();        }
        
        

    }



//1.map<map> 형태로 만들어서 장르<인덱스,값> 이렇게 넣고
//2.map<>형태로, <장르,합> 으로 장르 정렬함.
//3.정렬한 값을 통해서 1번에 접근해서 해당 장르도 정렬후, 상위 2개를 추출함. 
//4.상위 2개 값이 같다면, 값을 비교함. 
// 3~4를 반복함.