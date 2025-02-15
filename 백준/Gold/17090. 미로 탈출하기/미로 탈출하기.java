
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] graph;
    static int[][] dp; // -1:미방문, 1: 탈출 가능, 0: 탈출 불가능 (사이클)
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int answer =0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        dp = new int[N][M];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<M;j++){
                graph[i][j] = str.charAt(j);
                dp[i][j] = -1; // 초기값을 -1 설정
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                if (dfs(i, j)) answer++; 
            }
        }
        System.out.println(answer);

    }
    private static boolean dfs(int i, int j) {
        // 범위를 벗어나면 탈출 가능
        if (i < 0 || j < 0 || i >= N || j >= M) return true;

        // 이미 탐색한 경우
        if (dp[i][j] != -1) return dp[i][j] == 1;

        // 방문 처리
        dp[i][j] = 0;

        int dir;
        if (graph[i][j] == 'U') dir = 0;
        else if (graph[i][j] == 'R') dir = 1;
        else if (graph[i][j] == 'D') dir = 2;
        else dir = 3;

        int ni = i + di[dir];
        int nj = j + dj[dir];

        if (dfs(ni, nj)) {
            dp[i][j] = 1;
            return true;
        }

        return false;
    }

}
