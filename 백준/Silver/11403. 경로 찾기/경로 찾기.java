
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] v;
    static  int[][] answer;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        answer = new int[N][N];

        for(int i=0;i<N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    list.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            v = new boolean[N];
            dfs(i, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
    static void dfs(int node,int nextNode){

        for(int newNode : list.get(nextNode)){
            if(!v[newNode]){
                v[newNode]= true;
                answer[node][newNode] = 1;
                dfs(node,newNode);
            }
        }
    }
}
