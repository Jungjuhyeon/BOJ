import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] ia = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            ia[i][0] = Integer.parseInt(st.nextToken());
            ia[i][1] = Integer.parseInt(st.nextToken());
        }
        // 종료 시간이 같을 때 시작 시간을 기준으로 정렬
        Arrays.sort(ia, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        
        int answer =1; //정답
        int finish_time = ia[0][1]; //종료시간 - 초기 세팅

        for(int i=1;i<N;i++){
            if(finish_time<=ia[i][0]){ //종료시간보다 시작시간이 크거나 같을때 -이미 정렬되어있으므로,
                answer++;
                finish_time = ia[i][1]; //종료시간을 업데이트함.
            }
        }

        System.out.println(answer);

    }
}