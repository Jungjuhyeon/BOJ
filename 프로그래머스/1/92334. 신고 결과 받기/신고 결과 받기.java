import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //Map<String,List<String>> map = new HashMap<>(); map으로 하면,  List를 초기화해줄수가없어.
        Map<String,Integer> map = new HashMap<>(); //idx 위치 저장
        for(int i=0;i<id_list.length;i++){
            map.put(id_list[i],i);
        }
        
        Set<String>[] reportSet = new HashSet[id_list.length];
        for(int i=0;i<id_list.length;i++){
            reportSet[i] = new HashSet<>();
        }
        
        Map<String,Integer> countMap = new HashMap<>();
        
        for(String r : report){
            String[] rep = r.split(" ");
            String a = rep[0];
            String b = rep[1];
            int aIdx = map.get(a);
            if(reportSet[aIdx].add(b)){
                countMap.put(b,countMap.getOrDefault(b,0)+1);
             };
        }
        
        int[] answer = new int[id_list.length];
        
        // 결과 계산
        for (int i = 0; i < id_list.length; i++) {
            for (String target : reportSet[i]) {
                if (countMap.getOrDefault(target, 0) >= k) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}


//map, set 구현해서 처리하면될듯?
//map으로 유저 : 신고한 아이디 list로 받고
//set으로 신고한애 +1;