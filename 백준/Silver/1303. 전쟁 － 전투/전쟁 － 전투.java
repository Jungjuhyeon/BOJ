
import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static boolean[][] v;
    static char[][] a;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int W = 0,B = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new char[M][N];
        v = new boolean[M][N];

        for(int i=0;i<M;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                a[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!v[i][j]){
                    bfs(i,j);
                }
            }
        }

        System.out.println(W + " "+ B);
    }
    private static void bfs(int i,int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        v[i][j] = true;
        char c = a[i][j];
        int w =0;
        int b =0;
        if(c == 'W') w++;
        else b++;

        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curI = ij[0];
            int curJ = ij[1];
            for(int d=0;d<4;d++){
                int ni = curI+di[d];
                int nj = curJ+dj[d];
                if(ni>=0 && nj>=0 && ni<M && nj<N && !v[ni][nj]){
                    if(a[ni][nj]==c){
                        v[ni][nj] = true;
                        q.offer(new int[]{ni,nj});
                        if(a[ni][nj] == 'W')w++;
                        else b++;
                    }
                }
            }
        }
        W+= w*w;
        B+= b*b;
    }
}
