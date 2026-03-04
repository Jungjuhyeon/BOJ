
import java.io.*;
import java.util.*;

//중복순열
public class Main {
    static int N,M;
    static int[] a,ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        perm(0);
        System.out.println(sb);

    }
    private static void perm(int cnt){
        if(cnt == M){
            for(int i=0;i<M;i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            ans[cnt] = a[i];
            perm(cnt+1);
        }
    }
}
