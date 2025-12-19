
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        sb.append("<");
        for(int i=1; i<=N; i++){
            list.add(i);
        }
        int idx = -1;
        for(int i=0; i<N-1; i++){
            idx = (idx+K) % list.size();
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
            idx -=1;
        }
        sb.append(list.get(0));
        sb.append(">");

        System.out.println(sb);

    }
}
