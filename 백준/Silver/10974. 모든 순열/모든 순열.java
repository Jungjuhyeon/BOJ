import java.io.*;
import java.util.*;

public class Main {

    static int N,R;
    static int[] a,b;
    static boolean[] v;

    static StringBuilder sb;

    static void perm(int cnt) {
        if(cnt == R){
            for(int i=0;i<N;i++){
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i=0;i<N;i++){
            if(v[i]) continue;
            v[i]= true;
            b[cnt] = a[i];
            perm(cnt+1);
            v[i] = false; //중복 체크 안하면 중복 순열
        }

    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = N;

        a = new int[N];
        b = new int[R];
        v = new boolean[N];

        for(int i=1;i<=N;i++){
            a[i-1]= i;
        }

        perm(0);

        System.out.print(sb);

        
    }
}
