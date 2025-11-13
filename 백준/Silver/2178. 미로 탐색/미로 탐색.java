
import java.util.*;
import java.io.*;

public class Main {
    static int[][] a;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static boolean[][] v;
    static int N,M;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        a = new int[N][M];
        v = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                int num =s.charAt(j)-'0';
                a[i][j] = num;
            }
        }

        int count = bfs(0,0);

        System.out.println(count);
    }

    static int bfs(int b,int c){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{b,c,1});
        v[b][c] = true;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            int len = ij[2];

            if(i==N-1 && j ==M-1){
                return len;
            }
            for(int d=0;d<4;d++){
                int ni = i+di[d];
                int nj = j+dj[d];
                if(ni>=0 && ni<N && nj>=0 && nj<M && !v[ni][nj]){
                    if( a[ni][nj] == 1) {
                        q.offer(new int[]{ni, nj, len + 1});
                        v[ni][nj] = true;
                    }
                }
            }

        }
        return -1; // 도달 불가 시
    }
}
