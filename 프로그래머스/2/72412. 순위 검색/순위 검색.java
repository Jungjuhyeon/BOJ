import java.util.*;

class Solution {
    static Map<String,List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String inf : info){
            String[] infoArr = inf.split(" ");
            sub(infoArr,"",0);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        return answer;
    }
    	
    // 이분 탐색
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size();
 
        while (start < end) {
            int mid = start + (end-start)/ 2;
            if (list.get(mid) >= score)
                end = mid;
            else
                start = mid + 1;
        }
 
        return list.size() - start;
    }
    
    private void sub(String[] infoArr,String str,int cnt){
        if(cnt==4){
            if(!map.containsKey(str)){
                List<Integer> list = new ArrayList<>();
                map.put(str,list);
            }
            map.get(str).add(Integer.parseInt(infoArr[4]));
            return;
        }
        sub(infoArr,str+"-",cnt+1);
        sub(infoArr,str+infoArr[cnt],cnt+1);
    }
    
}