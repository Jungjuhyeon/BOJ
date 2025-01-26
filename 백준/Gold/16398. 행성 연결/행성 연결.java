
import java.io.*;
import java.util.*;

public class Main {
    static int[][] g;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<int[]> edgeList = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i < j) {
                    edgeList.add(new int[]{i, j, cost});
                }
            }
        }

        edgeList.sort((a, b) -> Integer.compare(a[2], b[2]));

        long total = 0;
        int edgeCount = 0;

        for (int[] edge : edgeList) {
            if (union(edge[0], edge[1])) {
                total += edge[2];
                edgeCount++;
            }
            if (edgeCount == N - 1) break;
        }

        System.out.println(total);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }
}
