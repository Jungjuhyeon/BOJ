
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (!(start == N && end == N))
        {
            if (sum > M || end == N) {
                sum -= a[start];
                start++;
            }
            else {
                sum += a[end];
                end++;
            }
            if (sum == M)
                count++;
        }
        System.out.println(count);

    }

}
