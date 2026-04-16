import java.util.*;

class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};

    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int m = board[0].length;
        String color = board[h][w];

        int count = 0;

        for(int d = 0; d < 4; d++){
            int ni = h + di[d];
            int nj = w + dj[d];

            if(ni >= 0 && nj >= 0 && ni < n && nj < m){
                if(board[ni][nj].equals(color)){
                    count++;
                }
            }
        }

        return count;
    }
}