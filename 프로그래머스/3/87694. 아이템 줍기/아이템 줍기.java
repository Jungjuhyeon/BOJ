import java.util.*;

class Solution {
    
    int[][] map = new int[102][102];
    boolean[][] v = new boolean[102][102];
    int[] di = {-1,0,1,0};
    int[] dj = {0,1,0,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            for(int x= x1;x<=x2;x++){
                for(int y= y1; y<=y2;y++){
                    map[x][y] = 1;
                }
            }
        }
        
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            for(int x= x1+1;x<x2;x++){
                for(int y= y1+1; y<y2;y++){
                    map[x][y] = 0;
                }
            }
        }
        
        return bfs(characterX * 2,
                   characterY * 2,
                   itemX * 2,
                   itemY * 2);        
    }
    private int bfs(int characterX, int characterY, int itemX, int itemY){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{characterX,characterY,0});
        
        v[characterX][characterY] = true;
        
        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curX = ij[0];
            int curY = ij[1];
            int dist = ij[2];
            
            if(curX ==itemX && curY == itemY){
                return dist/2;
            }
            
            for(int d=0;d<4;d++){
                int nextX = curX + dj[d];
                int nextY = curY + di[d];
                
                // 범위 체크
                if(nextX < 0 || nextY < 0 ||
                   nextX >= 102 || nextY >= 102){
                    continue;
                }

                // 방문 체크
                if(v[nextX][nextY]){
                    continue;
                }

                // 길(테두리)인지 확인
                if(map[nextX][nextY] != 1){
                    continue;
                }

                v[nextX][nextY] = true;

                q.offer(new int[]{
                        nextX,
                        nextY,
                        dist + 1
                });
            }
            
        }
      return 0;

    }
}