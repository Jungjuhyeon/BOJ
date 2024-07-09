import java.util.*;
import java.io.*;
public class Main {

    static int N,sum;
    static List<Integer>[] g;
    static boolean[] v;

    static void dfs(int i){
        v[i] =true;
        for(int j : g[i]){
            if(!v[j]){
                dfs(j);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        g = new List[N+1];
        v = new boolean[N+1];

        for(int i=0;i<N+1;i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[to].add(from);
            g[from].add(to);
        }

        for(int i=1;i<N+1;i++){
            if(!v[i]) {
                dfs(i);
                sum++;
            }
        }

        System.out.println(sum);
    }
}
