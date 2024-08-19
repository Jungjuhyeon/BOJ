
import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] v;
    static int[][] b;

    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    static int r=0,m,n;

    static int dfs(int i,int j){
        v[i][j] =true;
        r++;
        for(int d=0;d<4;d++){
            int xi = i+di[d];
            int yj = j+dj[d];
            if(xi>=1 && yj>=1&& xi<=n && yj<=m && !v[xi][yj]){
                dfs(xi,yj);
            }
        }
        return r;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

         st = new StringTokenizer(br.readLine()," ");
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
         int k = Integer.parseInt(st.nextToken());

         b = new int[n+1][m+1];
         v = new boolean[n+1][m+1];
         List<Integer> list = new ArrayList<>();

         for(int z=0; z<k;z++){
             st = new StringTokenizer(br.readLine()," ");
             int x1 = Integer.parseInt(st.nextToken());
             int y1 = Integer.parseInt(st.nextToken());
             int x2 = Integer.parseInt(st.nextToken());
             int y2 = Integer.parseInt(st.nextToken());
             for(int i=x1+1;i<=x2;i++){
                 for(int j=y1+1;j<=y2;j++){
                     v[i][j] =true;
                 }
             }
         }

         for(int i=1;i<n+1;i++){
             for(int j=1;j<m+1;j++){
                 if(!v[i][j]) {
                     list.add(dfs(i, j));
                     r=0;
                 }
             }
         }

         sb.append(list.size()).append("\n");

         int[] arr = new int[list.size()];
         for(int i=0;i<list.size();i++){
             arr[i] = list.get(i);
         }

         Arrays.sort(arr);

        for (int j : arr) {
            sb.append(j).append(" ");
        }

        br.close();
        System.out.println(sb);
    }
}
