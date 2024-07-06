import java.io.*;
import java.util.*;

public class Main {
    static int x,y,k,num =0;

    static int[][] ai;
    static boolean[][] v;
    static final int[] di ={-1,0,1,0};
    static final int[] dj = {0,1,0,-1};

    static void dfs(int i,int j){
        v[i][j] = true;
        for(int d=0;d<4;d++){
            int ni = i+ di[d];
            int nj = j+ dj[d];
            if(ni>=0&& nj>=0 && ni<y && nj<x && !v[ni][nj]){
                if(ai[ni][nj] ==1) {
                    dfs(ni, nj);
                }
            }
        }
    }


    public static void main(String[] args)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken()); //가로
            y = Integer.parseInt(st.nextToken()); //세로
            k = Integer.parseInt(st.nextToken()); //개수
            ai = new int[y][x];
            v = new boolean[y][x];

            for(int i=0;i<k;i++){
                st = new StringTokenizer(br.readLine()," ");
                int nx = Integer.parseInt(st.nextToken()); //가로
                int ny = Integer.parseInt(st.nextToken()); //세로
                ai[ny][nx] = 1;
            }


            for(int i=0;i<y;i++){
                for(int j=0;j<x;j++){
                    if(!v[i][j] && ai[i][j] ==1) {
                        dfs(i, j);
                        num++;
                    }
                }
            }
            sb.append(num).append("\n");
            num =0;
        }
        System.out.println(sb);
        br.close();
    }
}
