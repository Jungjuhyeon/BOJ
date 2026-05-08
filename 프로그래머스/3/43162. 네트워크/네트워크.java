import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List<Integer>[] list = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(computers[i][j]==1){
                    list[i].add(j);
                }
            }
        }
        
        boolean[] v = new boolean[n];
        int answer =0;
        for(int i=0;i<n;i++){
            if(!v[i]){
                bfs(list,v,i);
                answer++;
            }
        }
        return answer;
        
        
    }
    
    private void bfs(List<Integer>[] list, boolean[] v,int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        v[start]=true;
        
        while(!q.isEmpty()){
            int curNum = q.poll();
            for(int nextNum : list[curNum]){
                if(!v[nextNum]){
                v[nextNum] = true;
                q.offer(nextNum);
                }
            }
        }
    
    }
    
}