
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];

            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                int num = Integer.parseInt(st.nextToken());
                prices[i] = num;
            }

            long profit =0;
            int max =0;

            for(int i= N-1;i>=0;i--){
                if(prices[i]>max){
                    max = prices[i];
                }else{
                    profit += max-prices[i];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);

    }
}

//나보다 큰놈이 있나? 있으면 산다.
//나보다 큰놈이 없다? 팔게없으면  안산다, 안판다.
//