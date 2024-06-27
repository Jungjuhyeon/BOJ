import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] ia = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            ia[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ia);

        int sum = 0;
        int j =N;

        for (int i = 0; i < N; i++) {
            sum = sum+(ia[i] * j);
            //System.out.println(sum);
            --j;

        }

        System.out.println(sum);

    }
}

