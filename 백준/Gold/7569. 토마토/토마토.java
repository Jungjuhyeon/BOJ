
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][][] a;
    static boolean[][][] v;
    static int[] dz = {1,0,0,0,0,-1};
    static int[] di = {0,-1,0,1,0,0};
    static int[] dj = {0,0,1,0,-1,0};
    static ArrayDeque<int[]> q = new ArrayDeque<>();


    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        a = new int[H][N][M];
        v = new boolean[H][N][M];

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine()," ");
                for(int z=0;z<M;z++){
                    a[i][j][z] = Integer.parseInt(st.nextToken());
                    if(a[i][j][z]==1){
                        v[i][j][z] =true;
                        q.offer(new int[]{i,j,z});
                    }
                }
            }
        }

        int depth = bfs();

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int z=0;z<M;z++) {
                    if(a[i][j][z] ==0){
                        depth = -1;
                    }
                }

            }
        }
        br.close();
        System.out.println(depth);

    }
    public static int bfs(){
        int depth = 0;
        while(!q.isEmpty()){
            int SIZE = q.size();
            for(int i=0;i<SIZE;i++) {
                int[] zij = q.poll();
                int cz = zij[0];
                int ci = zij[1];
                int cj = zij[2];
                for(int d=0;d<6;d++){
                    int nz = cz+dz[d];
                    int ni = ci+di[d];
                    int nj = cj+dj[d];
                    if(nz>=0 && nz<H && ni>=0&&ni<N&& nj>=0&&nj<M && !v[nz][ni][nj]){
                        if(a[nz][ni][nj]==0){
                            a[nz][ni][nj] = 1;
                            q.offer(new int[]{nz,ni,nj});
                            v[nz][ni][nj]= true;
                        }
                    }
                }
            }
            // depth는 모든 현재 레벨을 처리한 후 증가
            if (!q.isEmpty()) {
                depth++;
            }
        }
        return depth;
    }
}
