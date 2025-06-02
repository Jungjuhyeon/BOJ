import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        int result =0;
        String st = br.readLine();

        for(int i=0;i<st.length();i++){
            String s = st.charAt(i)+ "";
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(int i=0;i<N-1;i++){
            String str = br.readLine();
            int[] wordCount = new int[26];

            for(int j=0;j<str.length();j++){
                wordCount[str.charAt(j)-'A']++;
            }
            int diff = 0;
            for (int j = 0; j < 26; j++) {
                int baseCount = map.getOrDefault((char)(j + 'A') + "", 0);
                int compareCount = wordCount[j];
                diff += Math.abs(baseCount - compareCount);
            }

            if(diff ==0 || diff==1 || (diff == 2 && st.length() == str.length())){
                result++;
            }

        }
        System.out.println(result);

    }

}
