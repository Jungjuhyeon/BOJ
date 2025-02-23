import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pickNum = nums.length /2;
        
        HashSet<Integer> hash = new HashSet<>();
        
        for(int i : nums){
            hash.add(i);
        }
        
        if(hash.size() >= pickNum){
            answer = pickNum;
        }else{
            answer = hash.size();
        }
        return answer;
    }
}