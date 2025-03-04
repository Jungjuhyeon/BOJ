
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] graph;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int count =0;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine()," ");
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine()," ");

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startBangHang = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }

        cleaning(startX,startY,startBangHang);
        System.out.println(count);

    }
    private static void cleaning(int x, int y, int direction){
        while(true){

            if (graph[x][y] == 0) { // 현재 위치 청소
                graph[x][y] = 2; // 청소 완료 표시 (1은 벽, 2는 청소 완료)
                count++;
            }

            boolean found = false;
            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4; // 반시계 방향 회전
                int nx = x + di[direction];
                int ny = y + dj[direction];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }
            if (!found) { // 네 방향 모두 청소 불가능한 경우 후진
                int backDirection = (direction + 2) % 4;
                int bx = x + di[backDirection];
                int by = y + dj[backDirection];

                if (bx >= 0 && bx < N && by >= 0 && by < M && graph[bx][by] != 1) {
                    x = bx;
                    y = by;
                } else {
                    break; // 후진도 불가능하면 종료
                }
            }
        }
    }
}

/**
 * 1. 현재 칸 청소 x -> 청소처리
 * 2. 주변 청소되어있다면 -> 후진
 *      후진않되면 종료
 * 3. 주변 청소 되지x
 *    1. 90도 회전
 *    2. 바로 앞 청소x ->전진
 */