
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        Map<Integer,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int count =0;
        int answer =0;

        for(int end =0; end<N;end++){
            map.put(a[end],map.getOrDefault(a[end],0)+1);
            count = map.size();

            if(count<=2){
                answer = Math.max(answer,end-start+1);
            }

            while(count>2){
                map.put(a[start],map.get(a[start])-1);
                if(map.get(a[start]) ==0){
                    map.remove(a[start]);
                }
                start++;
                count = map.size();
            }
        }
        System.out.println(answer);
    }
}
