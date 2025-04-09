
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String str= br.readLine();
            map.put(str,map.getOrDefault(str,0)+1);
        }

        List<String> sortList = new ArrayList<>(map.keySet());
        sortList.sort((a,b)->{
            int result = Integer.compare(map.get(b),map.get(a)); //내림차순
            if(result ==0){
                return a.compareTo(b);
            }
            return result;
        });

        System.out.println(sortList.get(0));
    }
}
