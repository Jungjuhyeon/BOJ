
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] ia, copyMap;
    static int[] bi = {-1,0,1,0};
    static int[] bj = {0,1,0,-1};
    static boolean[][] v;
    static int result = Integer.MIN_VALUE;


    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ia[i][j] == 0) {
                    ia[i][j] = 1;
                    dfs(cnt + 1);
                    ia[i][j] = 0;
                }
            }
        }
    }
    static int bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        copyMap = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(ia[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copyMap[i][j] = ia[i][j];
            }
        }
        while(! q.isEmpty()){
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            for(int d=0;d<4;d++){
                int ni = i+bi[d];
                int nj = j+bj[d];
                if(ni>=0 && nj>=0 && ni<N &&nj<M ){
                    if(copyMap[ni][nj] == 0){
                        copyMap[ni][nj] = 1;
                        q.offer(new int[]{ni,nj});
                    }

                }
            }
        }
        count(copyMap);
        return result;
    }

    static void count(int[][] copyMap){
        int count =0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                if(copyMap[i][j] ==0){
                    count++;
                }
            }
        }
        result = Math.max(result,count);

    }


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ia = new int[N][M];
        v = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                ia[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);

    }
}

