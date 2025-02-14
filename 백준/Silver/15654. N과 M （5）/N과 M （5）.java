
import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] a,b;
    static boolean[] v;
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        b = new int[N];
        v = new boolean[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        perm(0);

        System.out.println(sb.toString());
    }

    private static void perm(int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(v[i]) continue;
            v[i] = true;
            b[depth] = a[i];
            perm(depth+1);
            v[i] = false;
        }
    }
}


