import java.util.*;

class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static char[][] a;
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        a = new char[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c = storage[i].charAt(j);
                a[i][j] = c;
            }
        }
        for(String s : requests){
            int len = s.length();
            char search = s.charAt(0);
            if(len==2){
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(search == a[i][j]){
                            a[i][j] ='@';
                        }
                    }
                }
            }else{
                List<int[]> removeList = new ArrayList<>();

                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(search == a[i][j]){
                            if(bfs(i,j,n,m)){
                                removeList.add(new int[]{i,j});
                            }
                        }
                    }
                }
                for(int[] ij : removeList){
                    a[ij[0]][ij[1]] = '@';
                }
            }
        }
        
        int answer =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j] != '@'){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean bfs(int i,int j,int n,int m){
        boolean[][] v= new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i,j});
        
        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curI = ij[0];
            int curJ = ij[1];
            if(curI==0 || curJ==0 ||curI==n-1||curJ==m-1) return true;
            for(int d=0;d<4;d++){
                int ni = curI+di[d];
                int nj = curJ+dj[d];
                if(ni>=0 && nj>=0 && ni<n && nj<m && !v[ni][nj]){
                    if(a[ni][nj] =='@'){
                        q.offer(new int[]{ni,nj});
                        v[ni][nj] =true;
                    }
                }
            }
        }
        return false;
    }
}