import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String s = br.readLine();
            if(s.length()<M){
                continue;
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }

        List<StringLen> list =new ArrayList<>();

        for(String s : map.keySet()){
            list.add(new StringLen(s,map.get(s)));
        }

        Collections.sort(list,(a,b)-> {
            if(a.count != b.count){
                return Integer.compare(b.count,a.count);
            }else if(a.name.length() != b.name.length()){
                return Integer.compare(b.name.length(),a.name.length());
            }else{
                return a.name.compareTo(b.name);
            }
        });

        for(StringLen sL : list){
            sb.append(sL.name).append("\n");
        }

        System.out.println(sb);
    }

    public static class StringLen{
        String name;
        int count;

        public StringLen(String name, int count){
            this.name = name;
            this.count = count;
        }

    }
}
