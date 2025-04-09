
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N != 0) {

            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String value = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (String key : map.keySet()) {
                int i = map.get(key);
                answer *= (i + 1);
            }
            sb.append(answer - 1).append("\n");

            N--;
        }
        br.close();
        System.out.println(sb);
    }
}
