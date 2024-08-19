import java.io.*;
import java.util.*;

public class Main {
    static boolean[] v;
    static char[][] b;
    static int x,y,max=0;

    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};

    static void dfs(int i,int j,int answer){
        max =Math.max(answer,max);
        int check = b[i][j]-'A';
        v[check] = true;
        for(int d=0;d<4;d++){
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0&&nj>=0&&ni<y&&nj<x){
                if(!v[b[ni][nj]-'A']){
                    dfs(ni,nj,answer+1);
                    v[b[ni][nj]-'A'] = false;  // 백트래킹 시 방문 상태 초기화
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        y = Integer.parseInt(st.nextToken()); //세로
        x = Integer.parseInt(st.nextToken()); //가로

        v = new boolean['z'-'a'+1]; //26

        b = new char[y][x];

        for(int i = 0;i<y;i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                b[i][j] = str.charAt(j);
            }
        }
        dfs(0,0,1);
        System.out.println(max);

    }
}
