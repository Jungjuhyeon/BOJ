import java.util.*;

class Solution {
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        v = new boolean[n];
        
        int answer =0;
        
        for(int i=0;i<n;i++){
            if(!v[i]){
                answer++;
                dfs(i,n,computers);
            }
        }
        return answer;
    }
    
    public static void dfs(int i,int n,int[][] computers){
        v[i] = true;
        
        for(int j=0;j<n;j++){
            if(computers[i][j] == 1 && !v[j]){
                dfs(j,n,computers);
            }
        }
        
    }
}