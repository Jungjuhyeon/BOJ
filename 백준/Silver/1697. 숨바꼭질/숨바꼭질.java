
import java.io.*;
import java.util.*;

//count를 세야 되면 DFS, 그리고 필요 없으면 DFS나 BFS 중 편한 것을 쓰면 된다.

public class Main {
    static int MIN = Integer.MIN_VALUE;
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }
        
        boolean[] v = new boolean[100001];
        v[N] = true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        int count =0;;
        
        while(true){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int x = q.remove();
                v[x] =true;
                if(x-1 ==K || x+1 ==K || x*2 ==K){
                    System.out.println(count);
                    return;
                }
                if(x-1>=0 && !v[x-1]){
                    v[x-1] = true;
                    q.add(x-1);
                }
                if(x+1<=100000 && !v[x+1]){
                    v[x+1] = true;
                    q.add(x+1);
                }if(x*2<=100000 && !v[x*2]){
                    v[x*2] = true;
                    q.add(x*2);
                }
            }
        }

    }

}
