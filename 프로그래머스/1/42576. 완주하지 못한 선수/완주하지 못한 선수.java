import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String,Integer> map = new HashMap<>();
        String answer = "";

        for(String s : participant){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        for(String s : completion){
            map.put(s,map.get(s)-1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key)!=0){
                answer += key;
            }
        }
        
        return answer;
    }
}