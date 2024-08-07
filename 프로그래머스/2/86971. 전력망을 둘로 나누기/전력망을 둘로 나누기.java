import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 엣지 추가
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int minDifference = Integer.MAX_VALUE;
        
        // 각 엣지를 제거하고 결과를 확인
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            // 엣지 제거
            graph[a].remove((Integer)b);
            graph[b].remove((Integer)a);
            
            // DFS를 통해 하나의 컴포넌트의 크기 측정
            boolean[] visited = new boolean[n + 1];
            int componentSize = dfs(a, graph, visited);
            
            // 나머지 컴포넌트의 크기 계산
            int otherComponentSize = n - componentSize;
            
            // 차이 계산 및 최솟값 갱신
            minDifference = Math.min(minDifference, Math.abs(componentSize - otherComponentSize));
            
            // 엣지 복원
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return minDifference;
    }

    // DFS 함수
    private int dfs(int node, List<Integer>[] graph, boolean[] visited) {
        if (visited[node]) return 0;
        
        visited[node] = true;
        int size = 1; // 현재 노드를 포함
        
        for (int neighbor : graph[node]) {
            size += dfs(neighbor, graph, visited);
        }
        
        return size;
    }
}

//1. 젤 많이 연결되어있는 애를 먼저 찾는다.
//2. 그 놈 중에 연결된 애 중 젤 많이 연결되어있는 쪽을 끊는다. dfs 써도 될듯?