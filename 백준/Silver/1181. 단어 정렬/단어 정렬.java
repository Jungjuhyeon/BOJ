import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] sa = new String[N];

        for(int i=0;i<N;i++){
            sa[i] = br.readLine();
        }

        Arrays.sort(sa,(o1,o2)->{
            if(o1.length() ==o2.length()){
                return o1.compareTo(o2);
            }else{
                return Integer.compare(o1.length(),o2.length());

            }
        });
        sb.append(sa[0]).append('\n');

        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 출력
            if (!sa[i].equals(sa[i - 1])) {
                sb.append(sa[i]).append('\n');
            }
        }

        System.out.print(sb);

    }
}
