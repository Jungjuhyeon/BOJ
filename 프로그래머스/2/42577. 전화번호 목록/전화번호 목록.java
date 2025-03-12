import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String s : phone_book){
            set.add(s);
        }
        
        for(String s : set){
            
            for(int i=1;i< s.length();i++){
                String str = s.substring(0,i);
                if(set.contains(str)){
                    return false;
                }
            }
        }
        return true;
    }
}