import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속 먹는 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1]; // 초밥 종류별 개수
        int unique = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) unique++;
            count[arr[i]]++;
        }

        int max = unique;
        if (count[c] == 0) max++; // 쿠폰 초밥이 없다면 +1

        // 슬라이딩 윈도우
        for (int i = 1; i < N; i++) {
            // 앞 요소 제거
            int remove = arr[i - 1];
            count[remove]--;
            if (count[remove] == 0) unique--;

            // 뒤 요소 추가 (회전 초밥이므로 원형 배열)
            int add = arr[(i + k - 1) % N];
            if (count[add] == 0) unique++;
            count[add]++;

            int temp = unique;
            if (count[c] == 0) temp++;
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}