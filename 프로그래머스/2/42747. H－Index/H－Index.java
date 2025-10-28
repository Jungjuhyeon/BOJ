import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int n = citations.length;
        Arrays.sort(citations);
        
        int maxNum = citations[n-1];
                
        int inyong = 0;
        int nInyong = n;
        
        int max =0;
        
        for(int h=0 ; h<maxNum;h++){
            for(int i=0;i<n;i++){
                if(citations[i] >= h){
                    inyong = n-i;
                    nInyong = i;
                    break;
                }
            }
            if(inyong >=h && nInyong<=h){
                max = Math.max(max,h);
             }
        }
        
        return max;
        
    }
}
