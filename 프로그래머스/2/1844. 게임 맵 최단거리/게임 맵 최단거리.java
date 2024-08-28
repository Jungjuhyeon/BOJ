import java.util.*;

class Solution {
    boolean[][] v;
    final int[] di = {-1,0,1,0};
    final int[] dj = {0,1,0,-1};
    int length;
    
    public int solution(int[][] maps) {
        length = maps.length;
        v = new boolean[length][maps[0].length];
       
        return bfs(0,0,maps);
       

    }
    public int bfs(int i,int j, int[][] maps){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{i,j,1});
        v[i][j] = true;
        while(!q.isEmpty()){
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            int depth = ij[2];
            
            // 목적지 도달 시 깊이 반환
            if (i == length - 1 && j == maps[0].length - 1) {
                return depth;
            }
            
            for(int d=0;d<4;d++){
                int ni = i+di[d];
                int nj = j+dj[d];
                if(ni>=0 && nj >=0 && ni<length && nj<maps[0].length && !v[ni][nj]){
                    if(maps[ni][nj] ==1){
                        v[ni][nj] = true;
                        q.offer(new int[]{ni,nj,depth+1});
                    }
                }
            }
        }

        return -1;
    }
}