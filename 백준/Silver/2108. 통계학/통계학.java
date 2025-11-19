
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            a[i] = num;
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(a);

        // 1. 평균 (반올림)
        sb.append(Math.round((double) sum / N)).append("\n");

        // 2. 중앙값
        sb.append(a[N / 2]).append("\n");

        // 3. 최빈값
        int maxFreq = 0;
        for (int v : map.values()) {
            maxFreq = Math.max(maxFreq, v);
        }

        List<Integer> freqList = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) freqList.add(key);
        }

        Collections.sort(freqList);

        if (freqList.size() > 1) {
            // 두 번째로 작은 값
            sb.append(freqList.get(1)).append("\n");
        } else {
            // 하나면 그 값
            sb.append(freqList.get(0)).append("\n");
        }

        // 4. 범위
        sb.append(a[N - 1] - a[0]).append("\n");

        System.out.println(sb);
    }
}