
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new HashMap<>();

        String input;
        int totalCount =0;

        while((input = br.readLine()) !=null){
            map.put(input,map.getOrDefault(input,0)+1);
            totalCount++;
        }
        List<String> sortList = new ArrayList<>(map.keySet());
        sortList.sort((a,b) -> a.compareTo(b)); //사전순 정렬

        for(String key : sortList){
            Integer count =map.get(key);
            double percent = ((double) count /totalCount) * 100.0;
            sb.append(key).append(" ").append(String.format("%.4f", percent)).append("\n");
        }

        System.out.println(sb);

    }
}
