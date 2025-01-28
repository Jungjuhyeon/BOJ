
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static boolean[][] v;
    static int[][] g;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int answer = 0;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        v = new boolean[N][M];
        g = new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                g[i][j] = str.charAt(j) -'0';
            }
        }

        bfs(0,0);

        br.close();

        System.out.println(answer);

    }
    static void bfs(int i,int j){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{i,j,0});
        v[i][j] =true;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            if(x == N-1 && y ==M-1){
                answer = cost;
                break;
            }
            for(int d=0;d<4;d++){
                int ci = x + di[d];
                int cj = y + dj[d];

                if(ci>=0 && cj>=0 && ci<N && cj <M && !v[ci][cj]){
                    if(g[ci][cj]==1){
                        v[ci][cj] =true;
                        pq.offer(new int[]{ci,cj,cost+1});
                    }else{
                        v[ci][cj] =true;
                        pq.offer(new int[]{ci,cj,cost});
                    }
                }
            }
        }
    }

}
