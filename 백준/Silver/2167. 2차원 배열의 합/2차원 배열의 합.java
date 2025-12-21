import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=M;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int d=0;d<K;d++){
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum =0;

            for(int c=i;c<=x;c++){
                for(int b=j;b<=y;b++){
                    sum += a[c][b];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
}
