
import java.util.*;
import java.io.*;

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
        sub(0,0);

        System.out.println(sb);

    }
    private static void sub(int cnt,int start){
        if(cnt == M){
            for(int i=0;i<M;i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<N;i++){
            ans[cnt] = a[i];
            sub(cnt+1,i);
        }
    }
}
