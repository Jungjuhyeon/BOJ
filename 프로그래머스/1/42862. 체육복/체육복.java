import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] answer = new int[n+1];
        
        for(int i=1;i<n+1;i++){
            answer[i] = 1;
        }
        
        for(int i:lost){
            answer[i] = 0;
        }
        
        for(int i:reserve){
            answer[i] +=1;
        }
        
        for(int i=1;i<n;i++){
            if(answer[i]==0){
                if(answer[i-1]>=2){
                    answer[i-1]--;
                    answer[i] =1;
                }else if(answer[i+1]>=2){
                    answer[i+1]--;
                    answer[i] =1;
                }
            }
        }
        if(answer[n]==0){
            if(answer[n-1]>=2){
                answer[n-1]--;
                answer[n] =1;
            }
        }
        
        int anw = n;
        for(int i=1;i<n+1;i++){
            if(answer[i] ==0){
                anw--;
            }
        }
        
        return anw;
        
       
    }
}

//lost로 reserve에 번호가 있으면 그 번호를 지움.
//도난 당한 사람을 기준으로 +1,-1해서 있다면 reserve에서 삭제. 
// 총 개수 리턴