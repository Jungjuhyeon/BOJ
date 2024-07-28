import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // jobs를 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        // 우선순위 큐를 작업의 소요시간 기준으로 오름차순 정렬되도록 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int time = 0; // 현재 시간
        int totalWaitTime = 0; // 총 대기 시간
        int jobIndex = 0; // jobs 배열의 인덱스
        int count = 0; // 완료된 작업의 수

        // 모든 작업을 처리할 때까지 반복
        while (count < jobs.length) {
            // 현재 시간보다 이전에 요청된 모든 작업을 큐에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }
            
            if (pq.isEmpty()) {
                // 처리할 작업이 없으면 시간을 다음 작업의 요청 시간으로 이동
                time = jobs[jobIndex][0];
            } else {
                // 큐에서 가장 짧은 작업을 꺼내어 처리
                int[] job = pq.poll();
                time += job[1];
                totalWaitTime += time - job[0];
                count++;
            }
        }
        
        // 평균 대기 시간 계산
        return totalWaitTime / jobs.length;
    }
}


//1. 젤 요청시간이 빠른 거 부터 시작.
//2. 우선순위 큐를 사용해서, 길이가 젤 낮은 거부터 실행하게 끔한다.
//3. 근데 길이가 젤 작아도, 앞에 실행이 끝났는데, 요청이 시간이 그 안에 있어야 실행가능.