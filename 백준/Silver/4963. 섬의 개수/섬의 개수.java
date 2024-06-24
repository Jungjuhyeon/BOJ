
import java.io.*;
import java.util.*;

public class Main {
    static int x,y,C=0;
    static int[][] a;
    static boolean[][] v;
    static final int[] dj ={-1,-1,0,1,1,1,0,-1};//y축
    static final int[] di = {0,1,1,1,0,-1,-1,-1}; //x축

    static void dfs(int i,int j){
        v[i][j] = true; // 방문 표시
        for (int d = 0; d < 8; d++) {
            int nj = j + dj[d];
            int ni = i + di[d];
            if (0 <= ni && ni < x && 0 <= nj && nj <y) {
                if(a[ni][nj]==1 && !v[ni][nj]){
                    dfs(ni, nj);

                }
            }
        }
    }



    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0) break;

            a  = new int[x][y]; //지도배열
            v = new boolean[x][y]; //방문한 곳 배열

            //지도배열에 숫자 넣기
            for(int i=0;i<y;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<x;j++){
                    a[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            C = 0; // 섬의 개수 초기화

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (!v[i][j] && a[i][j] == 1) {
                        dfs(i, j);
                        C++; // 새로운 섬 발견 시 개수 증가
                    }
                }
            }
            System.out.println(C);
        }
    }
}
