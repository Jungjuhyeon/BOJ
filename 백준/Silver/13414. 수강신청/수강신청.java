
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> hashSet = new LinkedHashSet<>();

        for(int i=0;i<M;i++){
            String str = br.readLine();
            if(hashSet.contains(str)){
                hashSet.remove(str);
            }
            hashSet.add(str);
        }


        for(String str : hashSet){
            if(N>0){
                sb.append(str).append("\n");
                N--;
            }
        }

        System.out.println(sb);

    }
}
