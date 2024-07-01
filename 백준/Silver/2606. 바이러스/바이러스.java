import java.io.*;
import java.util.*;

public class Main {
    static boolean[] v;
    static int N;
    static int C;
    static int sum=0;

    static int[][] ia;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        ia = new int[N+1][N+1];
        v = new boolean[N+1];

        for(int i=0;i<C;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ia[from][to] = 1;
            ia[to][from] =1;
        }
        dfs(1);

        System.out.println(sum);

    }

    static void dfs(int i){
        v[i] = true;
        for(int j=1;j<=N;j++){
            if(ia[i][j] !=0 && !v[j]){
                sum++;
                dfs(j);
            }
        }

    }
}
