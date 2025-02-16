
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] graph;
    static int[][] distance;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        distance = new int[N][M];

        for(int i=0;i<N;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        bfs(0,0);

        System.out.println(distance[N-1][M-1]);
    }

    public static void bfs(int startX,int startY){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{startX,startY});
        distance[startX][startY] =0;

        while(!dq.isEmpty()){
            int[] ij = dq.poll();
            int curI = ij[0];
            int curJ = ij[1];

            if(curI == N-1 && curJ == M-1){
                return;
            }

            for(int d=0;d<4;d++){
                int newI = curI + di[d];
                int newJ = curJ + dj[d];
                if(newI>=0 & newJ>=0 && newI<N && newJ<M){
                    if(graph[newI][newJ] == 1 && distance[newI][newJ]> distance[curI][curJ]+1){
                        distance[newI][newJ] = distance[curI][curJ]+1;
                        dq.addLast(new int[]{newI,newJ});
                    }
                    if(graph[newI][newJ] == 0 && distance[newI][newJ]> distance[curI][curJ]){
                        distance[newI][newJ] = distance[curI][curJ];
                        dq.addFirst(new int[]{newI,newJ});
                    }
                }
            }
        }
    }
}
