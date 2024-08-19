import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] v;
    static List<Integer>[] list;

    static int answer = -1;

    static void dfs(int x,int y, int depth){
        if(x == y){
            answer = depth;
            return;
        }
        v[x] = true;

        for(int i=0; i<list[x].size();i++){
            int next = list[x].get(i);
            if(!v[next]){
                dfs(next,y,depth+1);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        v = new boolean[N+1];
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int l = Integer.parseInt(br.readLine());

        for(int i=0; i<l;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(x,y,0);
        System.out.println(answer);
    }
}
