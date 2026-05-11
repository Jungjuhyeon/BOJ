import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i:nums){
            set.add(i);
        }
        
        int len = nums.length/2;
        
        if(set.size()>=len){
            return len;
        }else{
            return set.size();
        }
    }
}