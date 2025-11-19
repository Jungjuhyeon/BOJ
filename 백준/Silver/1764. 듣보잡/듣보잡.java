
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            String str = br.readLine();
            set.add(str);
        }

        for(int i=0;i<M;i++){
            String str = br.readLine();
            if(set.contains(str)){
                list.add(str);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(String s: list){
            System.out.println(s);
        }

    }
}
