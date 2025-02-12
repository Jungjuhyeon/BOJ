
import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[5][5];
    static int[] selected = new int[7]; // 7명의 학생 좌표를 저장할 배열
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        comb(0, 0, 0);
        System.out.println(answer);
    }

    // 25개 중에서 7개를 조합으로 뽑는 함수
    static void comb(int idx, int start, int S_count) {
        if (idx == 7) { // 7명을 뽑았을 때
            if (S_count >= 4 && isConnected()) { // 'S'가 4명 이상 + 연결되어 있는지 확인
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int x = i / 5; // x 좌표
            int y = i % 5; // y 좌표

            selected[idx] = i; // 현재 선택한 학생 위치 저장
            comb(idx + 1, i + 1, S_count + (map[x][y] == 'S' ? 1 : 0));
        }
    }

    // BFS를 사용하여 7명이 서로 연결되어 있는지 체크
    static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        Deque<int[]> queue = new ArrayDeque<>();

        // 첫 번째 학생을 큐에 넣기
        int startX = selected[0] / 5;
        int startY = selected[0] % 5;
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 1; // 연결된 학생 수
        int connected = 1; // BFS로 연결된 학생 수 확인

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + di[d];
                int ny = y + dj[d];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue; // 범위 초과

                // 현재 (nx, ny)가 7명 중 한 명인지 확인
                for (int i = 0; i < 7; i++) {
                    int sx = selected[i] / 5;
                    int sy = selected[i] % 5;

                    if (sx == nx && sy == ny && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        connected++;
                    }
                }
            }
        }

        return connected == 7; // 7명 모두 연결되어 있어야 함
    }
}


/**
 * 해당문제는 보고 bfs가 떠올랐다.
 * 근데 bfs 이걸 어케하지..? 생각이 들었다.
 * 근데 힌트는 5x5라고 한다..
 * 25개 중에 7개를 미리 뽑아서 조합으로 먼저 구한다 -> 생각치못함.. 25C7 = 480700
 * 그리고 bfs를 통해 서로 인접한가? 판단한다.
 */