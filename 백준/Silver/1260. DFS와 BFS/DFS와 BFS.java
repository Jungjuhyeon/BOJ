import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int node;
    static int line;
    static int start;
    static int[][] arg;
    static boolean[] check;

    static StringBuilder sb;

    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arg = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i =0;i<line;i++){
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arg[a][b] =1;
            arg[b][a] =1;

        }

        dfs(start);
        sb.append("\n");

        check = new boolean[node+1];
        bfs(start);

        System.out.println(sb);

    }

    public static void dfs(int start){
        check[start] = true;
        sb.append(start).append(" ");

        for(int i =0 ;i <= node;i++){
            if(arg[start][i] ==1 && !check[i]){
                check[i] =true;
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        queue.add(start);
        check[start] = true;

        while(!queue.isEmpty()){
            start = queue.poll();
            sb.append(start).append(" ");

            for(int i =0; i<=node;i++){
                if(arg[start][i] ==1 && !check[i]){
                    check[i] =true;
                    queue.add(i);
                }
            }

        }

    }
}
