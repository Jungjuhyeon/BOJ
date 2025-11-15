
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] v;
    static int[] a;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] arts) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new boolean[N+1];
        a = new int[N];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int cnt) {
        if (cnt == M) {
            for(int i=0;i<M;i++){
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(v[i])continue;
            v[i] = true;
            a[cnt] = i;
            dfs(cnt+1);
            v[i] =false;
        }
    }
}
