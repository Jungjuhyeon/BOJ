import java.util.*;
import java.io.*;

public class Main {
    static int N,C;
    static int[][] ia;
    static boolean[][] v;
    static final int[] di = {-1,0,1,0};//y축 상우하좌
    static final int[] dj = {0,1,0,-1};

    static int dfs(int i,int j){
        v[i][j] =true;
        C=1;
        for(int d=0;d<4;d++){
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && ni<N&&nj>=0 && nj<N){
                if(ia[ni][nj]==1 && !v[ni][nj]){
                    C += dfs(ni,nj);
                }
            }
        }
        return C;

    }

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ia = new int[N][N];
        v = new boolean[N][N];

        for(int i=0; i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                ia[i][j] = str.charAt(j)-'0';
            }
        }

        List<Integer> sort_num = new ArrayList<>();

        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if(!v[i][j]&& ia[i][j]==1){
                    C =dfs(i,j);
                    sort_num.add(C);
                }
            }
        }
        Collections.sort(sort_num);
        sb.append(sort_num.size()).append("\n");
        for(int size:sort_num){
            sb.append(size).append("\n");
        }
        System.out.println(sb);

    }
}