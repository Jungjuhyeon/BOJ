import java.io.*;
import java.util.*;

public class Main {
    static int[] di = {-2,-1,1,2,2,1,-1,-2};
    static int[] dj = {1,2,2,1,-1,-2,-2,-1};
    static boolean[][] v;

    static int N;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());

        for(int i=0;i<number;i++){
            N = Integer.parseInt(br.readLine());

            v = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int desX = Integer.parseInt(st.nextToken());
            int desY = Integer.parseInt(st.nextToken());

            int depth = bfs(curX,curY,desX,desY);

            sb.append(depth).append("\n");
        }

        System.out.println(sb);

    }

    public static int bfs(int x, int y, int desX, int desY){
        if(x == desX && y== desY){
            return 0;
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        v[x][y] = true;
        int depth =0;

        while(!q.isEmpty()){
            int SIZE = q.size();
            for(int i=0;i<SIZE;i++){
                int[] current = q.poll();
                int ci = current[0];
                int cj = current[1];

                for(int d=0;d<8;d++){
                    int ni = ci+di[d];
                    int nj = cj+dj[d];
                    if(ni>=0 && ni<N && nj>=0 && nj<N && !v[ni][nj]){
                        if(ni == desX && nj == desY){
                            return depth+1;
                        }
                        q.offer(new int[]{ni,nj});
                        v[ni][nj] = true;
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
