import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int Leftmax = Math.max(sizes[0][0],sizes[0][1]);  //왼쪽 큰값
        int Rightmax = Math.min(sizes[0][0],sizes[0][1]); //오른쪽 큰값
        
        for(int i=1;i<sizes.length;i++){
            int[] a = sizes[i];
            int MAX = Math.max(a[0],a[1]); //왼쪽 큰값
            int MIN = Math.min(a[0],a[1]);  //오른쪽 작은값
            Leftmax = Math.max(Leftmax,MAX);
            Rightmax = Math.max(Rightmax,MIN);
        }
        return Leftmax*Rightmax;
    }
}