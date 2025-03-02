
import java.io.*;
import java.util.*;

public class Main {
    static int N,K,L;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int[][] graph; //1:사과
    static int[][] bang; //방향 1: 왼쪽 2: 오른쪾
    static boolean[][] exist;//꼬리 존재하는
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        exist = new boolean[N+1][N+1];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        bang = new int[L][2];

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine()," ");
            int time = Integer.parseInt(st.nextToken());
            String banghang = st.nextToken();
            bang[i][0] = time;
            bang[i][1] = banghang.equals("D") ? 1 : 2;
        }
        int countTime =0;
        int curbanghang = 1;//방향 초기 오른쪽
        int banghangIndex =0; //방향인덱스
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,1});
        exist[1][1] = true;

        while(!q.isEmpty()){
            countTime++; //시간 증가

            int[] curXY = q.peekLast(); //현 머리 위치
            int curX = curXY[0];
            int curY = curXY[1];

            int nextX = curX + di[curbanghang];
            int nextY = curY + dj[curbanghang];

            // 벽에 부딪히거나 몸통에 닿으면 게임 종료
            if (nextX < 1 || nextY < 1 || nextX > N || nextY > N || exist[nextX][nextY]) {
                System.out.println(countTime);
                return;
            }

            // 머리 이동
            q.offer(new int[]{nextX, nextY});
            exist[nextX][nextY] = true;

            // 사과가 없으면 꼬리 줄이기
            if (graph[nextX][nextY] == 0) {
                int[] tail = q.poll(); // 꼬리 제거
                exist[tail[0]][tail[1]] = false;
            } else {
                graph[nextX][nextY] = 0; // 사과를 먹었으면 사과 제거
            }
            // 방향 변경 확인
            if (banghangIndex < L && bang[banghangIndex][0] == countTime) {
                if (bang[banghangIndex][1] == 1) { // 오른쪽 회전
                    curbanghang = (curbanghang + 1) % 4;
                } else { // 왼쪽 회전
                    curbanghang = (curbanghang + 3) % 4;
                }
                banghangIndex++;
            }

        }

        //벽에 안 닿아야함. 꼬리에 안 닿아야함.
        //사과를 먹으면 꼬리는 그대로 있고 없으면 꼬리는 줄어든다. 꼬리 줄어드는 로직을 어케 짜지?
        //끝나고 방향을 바꿔줘야한다.
    }
}
