import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[][] members = new String[N][2];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            members[i][0] = st.nextToken(); // 나이
            members[i][1] = st.nextToken(); // 이름
        }

        Arrays.sort(members, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
        }

        System.out.print(sb);



    }
}
