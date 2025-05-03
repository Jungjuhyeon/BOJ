
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer,Integer> map = new HashMap<>();
        int left =0;
        int max =0;

        for(int right =0; right<N;right++){
            int num = arr[right];
            map.put(num,map.getOrDefault(num,0)+1);

            while(map.get(num)>K){
                int leftNum = arr[left];
                left++;
                map.put(leftNum,map.get(leftNum)-1);
            }
            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);

    }
}

