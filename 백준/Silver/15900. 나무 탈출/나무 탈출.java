
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<Integer>[] list;
    static boolean[] v;
    static int answer;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
//        int[] i = new int[4];
        list = new List[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) { // 간선의 개수는 N-1
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        v = new boolean[N+1];

        answer=0;
        dfs(1,0);

        if(answer%2 ==0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
        
        br.close();


    }

    public static void dfs(int node, int cnt){
        v[node] = true;
        for(int next : list[node]){
            if(!v[next]){
                dfs(next,cnt+1);
            }
        }
        if(list[node].size() ==1 & node !=1){
            answer +=cnt;
        }
    }
}
