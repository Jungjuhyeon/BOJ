import java.util.*;

class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int N,M;
    static boolean[][] v;
    static int[][] group;
    public int solution(int[][] land) {

        N = land.length;
        M = land[0].length;
        
        group = new int[N][M];
        Map<Integer,Integer> size = new HashMap<>();
        
        int idx =1;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j] == 1 && group[i][j] ==0){
                    int num = bfs(i,j,land,idx);
                    size.put(idx,num);
                    idx++;
                }
            }
        }
        
        int max = 0;

        for(int col=0;col<M;col++){

            Set<Integer> set = new HashSet<>();

            for(int row=0;row<N;row++){
                if(group[row][col] != 0){
                    set.add(group[row][col]);
                }
            }

            int sum = 0;

            for(int g : set){
                sum += size.get(g);
            }

            max = Math.max(max,sum);
        }

        return max;
    }
    
    private static int bfs(int row,int col,int[][] land,int idx){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row,col});
        
        group[row][col] = idx;
        int sum = 1;
        
        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curI = ij[0];
            int curJ = ij[1];
            for(int d=0;d<4;d++){
                int ni = curI+di[d];
                int nj = curJ+dj[d];
                if(ni>=0 && nj>=0 && ni<N && nj<M){
                    if(group[ni][nj] ==0 && land[ni][nj]==1){
                        q.offer(new int[]{ni,nj});
                        group[ni][nj] = idx;
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}