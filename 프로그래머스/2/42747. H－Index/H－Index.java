import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int len = citations.length;
        int answer = 0;
        
        for(int h=0; h<=citations[len-1];h++){
            int up =0;
            int down =0;
            for(int j=0;j<len;j++){
                if(citations[j]>=h){
                    up = len-down;
                    break;
                }else{
                    down++;
                }
            }
            if(up>=h && down<=h){
                answer = Math.max(answer,h);
            }
        }
        return answer;
        
        
    }
}