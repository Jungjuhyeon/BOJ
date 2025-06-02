
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count =N;

        for(int i=0;i<N;i++){
            String str = br.readLine();
            set.add(str);
        }

        for(int i=0;i<M;i++){
            String[] arrStr = br.readLine().split(",");
            for(String s : arrStr){
                if(set.contains(s)){
                    count--;
                    set.remove(s);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


}
