
import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] p;
    static int[][] g;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n ==0 && m==0 )break;

            p = new int[n]; //부모
            g = new int[m][3];

            for (int i = 0; i < n; i++) {
                p[i] = i;  // 부모를 자기 자신으로 초기화
            }

            int answer = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                answer += c;
                g[i] = new int[]{a, b, c};
            }

            Arrays.sort(g, (a, b) -> Integer.compare(a[2], b[2]));

            int total = 0;
            int edge = 0;

            for (int[] a : g) {
                if (union(a[0], a[1])) {
                    total += a[2];
                    edge++;
                }
                if (edge == n - 1) break;
            }

            System.out.println(answer - total);
        }
    }

    private static int find(int a){
        if(p[a] != a){
            p[a] = find(p[a] );
        }
        return p[a];
    }
    private static boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            p[rootB] = rootA;
            return true;
        }
        else{
            return false;
        }

    }
}
