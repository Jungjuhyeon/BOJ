import java.util.*;

class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static boolean[][] v;
    static int n,m;
    static int[][] dist;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        v = new boolean[n][m];
        dist = new int[n][m];
        
        bfs(0,0,maps);
        
        
        return dist[n-1][m-1] == 0 ? -1:dist[n-1][m-1];
    }
    
    public static void bfs(int i,int j, int[][] maps){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i,j});
        dist[i][j] = 1;
        
        while(!q.isEmpty()){
            int[] ij = q.poll();
            int i1 = ij[0];
            int i2 = ij[1];
            
            for(int d=0;d<4;d++){
                int ni = i1+ di[d];
                int nj = i2+ dj[d];
                if(ni>=0 && ni<n && nj>=0 && nj<m && !v[ni][nj] && maps[ni][nj] ==1){
                    q.offer(new int[]{ni,nj});
                    v[ni][nj] = true;   
                    dist[ni][nj] = dist[i1][i2] + 1;
                }
            }

        }
        
    }
}