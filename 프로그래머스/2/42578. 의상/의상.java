import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String[] cl : clothes){
            map.put(cl[1],map.getOrDefault(cl[1],1)+1);
        }
        Integer sum =1;
        
        for(String key: map.keySet()){
            sum *= map.get(key);
        }
        
        return sum-1;
    }
}