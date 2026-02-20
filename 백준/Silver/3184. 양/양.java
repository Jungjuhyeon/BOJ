
import java.util.*;
import java.io.*;

public class Main {
    static int R,C,Y,N;
    static boolean[][] v;
    static char[][] a;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        v = new boolean[R][C];
        a = new char[R][C];

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                char c = s.charAt(j);
                a[i][j] = c;
                if(c == 'o'){
                    Y++;
                }
                if(c == 'v'){
                    N++;
                }
            }
        }

        for(int i=0;i<R;i++) {
            for (int j = 0; j < C; j++) {
                if(!v[i][j] && a[i][j] !='#'){
                    bfs(i,j);
                }
            }
        }
        sb.append(Y).append(' ').append(N);
        System.out.println(sb);

    }

    private static void bfs(int i,int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        v[i][j] = true;
        int o = 0;
        int n = 0;

        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curI = ij[0];
            int curJ = ij[1];
            if(a[curI][curJ] == 'o') o++;
            if(a[curI][curJ] == 'v') n++;
            for(int d=0;d<4;d++){
                int ni = curI + di[d];
                int nj = curJ + dj[d];
                if(ni>=0 && nj >=0 && ni<R && nj <C && !v[ni][nj] && a[ni][nj] != '#'){
                    v[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        if(o>n){
            N -= n;
        }else{
            Y -= o;
        }
    }
}
