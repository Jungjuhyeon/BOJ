import java.util.*;

class Solution {
    static List<int[]>[] list;
    public int solution(int[][] points, int[][] routes) {
        int robotLen = routes.length;
        list = new ArrayList[robotLen];

        for(int i=0;i<robotLen;i++){
            list[i] = new ArrayList<>();
        }
        int idx =0;
        for(int[] route : routes){
            list[idx].add(new int[]{
                points[route[0]-1][0],
                points[route[0]-1][1]
            });
            for(int i=0;i<route.length-1;i++){
                int start = route[i]-1;
                int end = route[i+1]-1;
                sol(points[start],points[end],idx);
            }
            idx++;
        }
        
        int maxTime = 0;

        for(List<int[]> l : list){
            maxTime = Math.max(maxTime, l.size());
        }

        int answer = 0;

        for(int t = 0; t < maxTime; t++){

            Map<String,Integer> map = new HashMap<>();

            for(List<int[]> l : list){

                if(t >= l.size()) continue;

                int[] p = l.get(t);
                String key = p[0] + "," + p[1];

                map.put(key, map.getOrDefault(key,0)+1);
            }

            for(int v : map.values()){
                if(v >= 2) answer++;
            }
            
        }
        return answer;

                          
    }
    private static void sol(int[] start,int[] end,int idx){
        int startI = start[0];
        int startJ = start[1];
        int endI = end[0];
        int endJ = end[1];
        
        while(startI!=endI){
            if(startI<endI)++startI;
            else --startI;
            
            list[idx].add(new int[]{startI,startJ});

        }
        while(startJ !=endJ){
            if(startJ<endJ)++startJ;
            else --startJ;
            
            list[idx].add(new int[]{startI,startJ});
        }
        
    }
}