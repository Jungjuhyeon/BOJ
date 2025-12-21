import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,a[i][j]);
                min = Math.min(min,a[i][j]);
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;

        for (int h = min; h <= max; h++) {
            int time = 0;
            int remove = 0; // 캐는 블록
            int add = 0;    // 쌓는 블록

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int cur = a[i][j];
                    if (cur > h) {
                        int diff = cur - h;
                        remove += diff;
                        time += diff * 2;
                    } else if (cur < h) {
                        int diff = h - cur;
                        add += diff;
                        time += diff;
                    }
                }
            }

            // 🔥 여기서 한 번만 체크
            if (B + remove < add) continue;

            if (time < answerTime || (time == answerTime && h > answerHeight)) {
                answerTime = time;
                answerHeight = h;
            }
        }
        System.out.print(answerTime);
        System.out.print(" ");
        System.out.print(answerHeight);

    }
}
