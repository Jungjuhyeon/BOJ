import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] b;
    static boolean[][] v;
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    static int sum;

    static void dfs(int i,int j,int high){
        v[i][j] =true;
        for(int d=0;d<4;d++){
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && nj>=0 && ni<=N-1 && nj<=N-1 && !v[ni][nj]){
                if(b[ni][nj]>high){
                    dfs(ni,nj,high);
                }
            }
        }
    }


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        b = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
               b[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(b[i]));
        }

        int max =0;
        for(int i=0;i<N;i++){ //젤 높은 곳 구하기
            for(int j=0;j<N;j++){
                max = Math.max(max,b[i][j]);
            }
        }

        int answer =0;

        for(int k=0;k<=max;k++){
            sum=0;
            v = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j] && b[i][j]>k) {
                        dfs(i, j, k);
                        sum++;
                    }
                }
            }
            answer = Math.max(sum,answer);
        }

        System.out.println(answer);



    }
}
