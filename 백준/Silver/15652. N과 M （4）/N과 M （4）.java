import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] a ,b;
    static boolean[] v = new boolean[N];
    static StringBuilder sb;

    static void comb(int cnt,int start){
        if(cnt == M){
            for(int i=0;i<M;i++) {
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =start;i<N;i++){
            b[cnt] = a[i];
            comb(cnt+1,i);
        }

    }


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a =new int[N];
        b= new int[M];

        for(int i=0;i<N;i++){
            a[i] = i+1;
        }
        comb(0,0);

        System.out.println(sb);

    }
}
