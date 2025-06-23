
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[] di = {1,1,1};
    static int[] dj = {-1,0,1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine()," ");

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++){
            dfs(0,i,arr[0][i],-1);

        }

        System.out.println(min);
    }

    static void dfs(int i,int j,int sum,int preDir){
        if(i==N-1){
            min = Math.min(min,sum);
        }else {
            for (int d = 0; d < 3; d++) {

                if(preDir == d) continue;

                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                    dfs(ni,nj,sum+arr[ni][nj],d);
                }
            }
        }
    }
}
