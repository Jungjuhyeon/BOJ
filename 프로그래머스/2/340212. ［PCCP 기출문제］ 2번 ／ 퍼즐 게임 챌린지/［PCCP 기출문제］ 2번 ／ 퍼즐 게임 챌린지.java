import java.util.*;


class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        return binary_search(diffs, times, limit);

    }

    public int binary_search(int [] diffs, int [] times, long limit) {
        int max = 1; int min = 100000; 
        while (max <= min){
            int level = (max+min)/2; 
            long mid = calcul(diffs,times, level);
            // 제한 시간을 초과함 -> level 상승
            if(mid > limit) max = level + 1; 
            // 제한시간보다 빨리 끝내거나 딱 맞출 때 -> level 하락
            else min = level - 1; 
        }
        return max;
    }

    public long calcul(int [] diffs, int [] times, int level) {
        long ans = 0;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= level) ans += times[i];
            else ans += (long)(times[i] + times[i-1])* (long)(diffs[i] - level) + times[i];
        }
        return ans;
    }

}

// class Solution {
//     static int answer = Integer.MAX_VALUE;
//     public int solution(int[] diffs, int[] times, long limit) {
//         int maxNum = 0;
        
//         for(int i=0;i<diffs.length;i++){
//             maxNum = Math.max(maxNum,diffs[i]);
//         }
        
//         for(int i=1;i<=maxNum;i++){
//             long sum =0;
//             for(int j=0;j<diffs.length;j++){
//                 if(j==0){
//                     sum += calculrate(diffs[j],i,times[j],(long)times[0]);
//                 }else{
//                     sum += calculrate(diffs[j],i,times[j],(long)times[j-1]);
//                 }                
//                 if((limit<sum)) break;
//             }
//             if(!(limit<sum)) answer = Math.min(i,answer);

//         }
//         return answer;
        
//     }
    
//     private long calculrate(int diff, int level,int time_cur,long time_prev){
//         if(diff<=level){
//             return time_cur;
//         }else{
//             return (diff-level)*(time_cur + time_prev) + time_cur;
//         }
//     }
// }


// diff <= level = time_cur
// diff > level =  (diff-level) x (time_cur + time_prev)
// diffs의 최대값 n
// 1~n으로 돌리면서 최소값구하기
