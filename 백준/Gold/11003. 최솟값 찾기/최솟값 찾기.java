
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<N;i++){

            // 1. 범위 벗어난 인덱스 제거
            if (!dq.isEmpty() && dq.peekFirst() < i - L + 1) {
                dq.pollFirst();
            }
            // 2. 뒤에서부터 현재 값보다 큰 값 제거
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            sb.append(arr[dq.peekFirst()]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
