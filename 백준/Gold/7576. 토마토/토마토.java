import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] ia;
    static boolean[][] v;
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();


    static int bfs() {
        int depth = 0;

        while (!q.isEmpty()) {
            int[] ijd = q.poll();
            int i = ijd[0];
            int j = ijd[1];
            depth = ijd[2];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= 0 && nj >= 0 && ni < N && nj < M && !v[ni][nj]) {
                    if (ia[ni][nj] == 0) {
                        v[ni][nj] = true;
                        ia[ni][nj] = 1;
                        q.offer(new int[]{ni, nj, depth + 1});
                    }
                }
            }
        }
        return depth;
    }


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ia = new int[N][M];
        v = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
               ia[i][j] = Integer.parseInt(st.nextToken());
               if(ia[i][j]==1){
                    v[i][j] =true;
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        int days = bfs();

        boolean allRipe = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ia[i][j] == 0) {
                    allRipe = false;
                    break;
                }
            }
        }

        if (allRipe) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }

    }
}