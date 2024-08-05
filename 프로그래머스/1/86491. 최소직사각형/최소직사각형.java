import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int Leftmax = 0;  //왼쪽 큰값
        int Rightmax = 0; //오른쪽 큰값
        
        for(int i=0;i<sizes.length;i++){
            int[] a = sizes[i];
            int MAX = Math.max(a[0],a[1]); //왼쪽 큰값
            int MIN = Math.min(a[0],a[1]);  //오른쪽 작은값
            Leftmax = Math.max(Leftmax,MAX);
            Rightmax = Math.max(Rightmax,MIN);
        }
        return Leftmax*Rightmax;
    }
}