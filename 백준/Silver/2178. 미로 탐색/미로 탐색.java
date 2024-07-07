import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] ai,b;
    static boolean[][] v;
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};

    //이런 최단경로 문제는 dfs로 풀지말자 왜냐하면 시간초과가 발생한다.
    static void dfs(int i,int j,int depth){
        v[i][j] = true;
        b[i][j] = depth;

//        System.out.println(i+" "+j + " "+ b[i][j]);
        if (i == N-1 && j == M-1) {
            return;
        }
        for(int d=0;d<4;d++){
            int ni = i +di[d];
            int nj = j +dj[d];
            if(ni>=0 && nj >=0 && ni<N && nj<M){
                if(!v[ni][nj]&& ai[ni][nj]==1) {
                    dfs(ni, nj, depth + 1);
                    v[ni][nj] = false;
                }
            }
        }
    }

    static int bfs(int i,int j,int depth){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j,depth});
        v[i][j] = true;



        while(!q.isEmpty()){
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            depth = ij[2];

            if (i == N-1 && j == M-1) {
                return depth;
            }            for(int d=0;d<4;d++){
                int ni = i +di[d];
                int nj = j +dj[d];
                if(ni>=0 && nj >=0 && ni<N && nj<M){
                    if(!v[ni][nj]&& ai[ni][nj]==1) {
                        v[ni][nj] = true;
                        q.offer(new int[]{ni,nj,depth+1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ai = new int[N][M];
        b= new int[N][M];
        v = new boolean[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                ai[i][j] = str.charAt(j)-'0';
            }
        }
        int depth =bfs(0,0,1);

        System.out.println(depth);
    }
}

