import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static boolean[] v;
    static ArrayList<Integer>[] list;
    static int[] parent;

    static void dfs(int i){
        v[i] = true; //방문
        for(int d: list[i]){
            if(!v[d]){
                parent[d] = i;
                dfs(d);
            }
        }

    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //노드 개수
        
        list = new ArrayList[N+1]; //연결된 노드가 무엇인지 넣는 리스트
        parent = new int[N+1]; //부모 노드 변수
        v = new boolean[N+1]; //방문변수

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
//        System.out.println(Arrays.toString(list));


        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            list[to].add(from);
            list[from].add(to); //이는 순서가 없는 그냥 연결되기에 노드가 두개로 연결(방향x) 
        }
//        System.out.println(Arrays.toString(list));


        dfs(1); //1번으로부터 트리가 생성되니 

        for(int i=1;i<N;i++){
            sb.append(parent[i+1]).append("\n");
        }

        System.out.println(sb);

        br.close();

    }

}
