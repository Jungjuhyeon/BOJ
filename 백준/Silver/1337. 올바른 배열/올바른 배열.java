
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 4; // 최대 4개까지 채워야 함 (5개 연속 만들어야 하니까)
        int start = 0;

        for(int end =0; end<N;end++){
            if(arr[end] - arr[start] >=5){
                start++;
            }
            int exist = end-start +1;
            answer = Math.min(answer, 5 - exist);
        }
        System.out.println(answer);

    }
}
