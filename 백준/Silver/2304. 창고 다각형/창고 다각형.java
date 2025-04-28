
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }

        list.sort((a,b)-> Integer.compare(a[0],b[0]));

        int maxHeight = 0;
        int maxIdx = 0;

        // 가장 높은 기둥 찾기
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] > maxHeight) {
                maxHeight = list.get(i)[1];
                maxIdx = i;
            }
        }

        int answer =0;
        int curHigh = list.get(0)[1];

        for(int i=0;i<maxIdx;i++){
            if(list.get(i)[1] >curHigh){
                curHigh = list.get(i)[1];
            }
            answer += (list.get(i+1)[0]-list.get(i)[0]) * curHigh;
        }

        curHigh = list.get(list.size()-1)[1];

        for(int i= list.size()-1;i>maxIdx;i--){
            if (list.get(i)[1] > curHigh) {
                curHigh = list.get(i)[1];
            }
            answer += (list.get(i)[0] - list.get(i - 1)[0]) * curHigh;
        }

        answer += maxHeight;

        System.out.println(answer);


    }

}


