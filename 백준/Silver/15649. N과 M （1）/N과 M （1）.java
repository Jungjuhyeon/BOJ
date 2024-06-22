
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int N,M;
    static int[] a,b;
    static boolean[] v;

    static void perm(int cnt){
        if(cnt == M){
            for(int i=0;i<M;i++){
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(v[i])continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt+1);
            v[i] =false;
        }
    }


    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb =new StringBuilder();

        st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];

        b = new int[M];

        v = new boolean[N];

        for(int i=0;i<N;i++){
            a[i] =i+1;
        }

        perm(0);

        System.out.print(sb);


    }

}

