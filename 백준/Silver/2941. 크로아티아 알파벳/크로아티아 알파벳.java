
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();

        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");

        String str = br.readLine();
        int answer =0;

        for(int i=0; i<str.length(); i++){
            boolean matched = false;

            for(int j=2;j<=3;j++){
                if (i + j <= str.length()) { // 범위 체크 필수
                    String s = str.substring(i, i + j);
                    if (set.contains(s)) {
                        answer++;
                        i += j - 1;
                        matched = true;
                        break;
                    }
                }
            }
            if(!matched){
                answer++;
            }
        }
        System.out.println(answer);
    }

}
