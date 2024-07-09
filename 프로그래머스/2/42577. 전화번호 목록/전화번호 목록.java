import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str : phone_book){
            map.put(str,1);
        }
        
        for(String str : phone_book){
            for(int i=1;i<str.length();i++){
                String prefix = str.substring(0,i);
                if(map.containsKey(prefix)) return false;
            }
        }
        
        return true;
    }
}