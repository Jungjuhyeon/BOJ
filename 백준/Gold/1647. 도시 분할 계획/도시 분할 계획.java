
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] g;
    static int[] parent;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        g = new int[M][3];
        parent = new int[N+1];
        for(int j=0;j<N+1;j++){
            parent[j]=j;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[i] = new int[]{a,b,c};
        }

        Arrays.sort(g,((a,b)->Integer.compare(a[2],b[2])));

        int answer = Integer.MAX_VALUE;
        int total = 0;
        int edge = 0;
        int maxCount = 0;


        for (int[] e : g) {
            if (union(e[0], e[1])) {
                total += e[2];
                edge++;
                maxCount = e[2];
            }
            if(edge==N-1){
                break;
            }
        }

        System.out.println(total-maxCount);

    }
    static int find(int a){
        if(parent[a] !=a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    static boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
            return true;
        }else{
            return false;
        }

    }
}

/**
 * 해당 문제는 MST 문제이다.
 * 크루스칼 알고리즘으로 최소비용을 만들어야한다.
 * 두개의 마을로 분리해야하므로, 시작하는 위치를 1을 -1로 하고, 차례대로 2,3,4,5, 정점들도 -1로 해서 최소 비용들을 구한다.
 * 그렇게 한 것 중 가장 작은 비용으로 한 놈이 정답이다.
 */
