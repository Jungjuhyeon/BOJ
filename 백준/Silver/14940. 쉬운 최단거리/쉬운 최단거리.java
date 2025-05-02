
import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int[][] graph;
    static int[][] answer;
    static boolean[][] v;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        answer = new int[N][M];
        v = new boolean[N][M];

        int startX = 0;
        int startY = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                if(num == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX,startY,0);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                if(graph[i][j] == 1){
                    if(answer[i][j] ==0){
                        answer[i][j] = -1;
                    }
                }
                System.out.print(answer[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }



    }
    static void bfs(int startX, int startY,int depth){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX,startY,depth});
        v[startX][startY] = true;

        while(!q.isEmpty()){
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            depth = xy[2];
            answer[x][y] = depth;
            for(int d=0;d<4;d++){
                int dx = x + di[d];
                int dy = y + dj[d];
                if(dx>=0 && dx<N && dy>=0 && dy<M && !v[dx][dy]){
                    if(graph[dx][dy] == 1) {
                        v[dx][dy] = true;
                        q.offer(new int[]{dx, dy,depth+1});
                    }
                }
            }
        }


    }
}
