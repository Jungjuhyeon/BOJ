import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
         int col;
       // 1. num 위치 찾기
        int row = (num - 1) / w;

        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - ((num - 1) % w);
        }

        // 2. 같은 col 위로 개수 세기
        int answer = 0;

        for (int r = row; r * w < n; r++) {
            int idx;

            if (r % 2 == 0) {
                idx = r * w + col;
            } else {
                idx = r * w + (w - 1 - col);
            }

            if (idx < n) {
                answer++;
            }
        }

        return answer;
    }
}