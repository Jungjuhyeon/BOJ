import java.util.*;

class Solution {
    int[] p;
    public int solution(int n, int[][] computers) {
        p = new int[n+1]; //1~n부모
        
        for(int i=1;i<n+1;i++){
                p[i] = i;
        }        
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(computers[i][j] ==1){
                    union(i+1,j+1);
                }
            }
        }
       
        
        // 네트워크 개수 세기
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(find(i) == i) {
                answer++;
            }
        }

        return answer;
      
    }
    
    public void union(int i,int j){
        int aRoot = find(i);
        int bRoot = find(j);
       
        p[bRoot] = aRoot;
    }
    
    public int find(int i){
        if(p[i]==i) return p[i];
        return p[i] = find(p[i]);
    }
}