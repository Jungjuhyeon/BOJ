
import java.io.*;
import java.util.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int N = Integer.parseInt(br.readLine());

        // 1. 팀 이름 각 문자의 개수 계산
        HashMap<Character, Integer> teamCountMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            teamCountMap.put(S.charAt(i), teamCountMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        // 2. 주어진 이름 첫 글자의 빈도 저장
        HashMap<Character, Integer> memberFirst = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            memberFirst.put(name.charAt(0), memberFirst.getOrDefault(name.charAt(0), 0) + 1);
        }

        long[] answerArr = new long[teamCountMap.size()];
        int index = 0;
        for (char teamCountMapKey : teamCountMap.keySet()) {
            int teamCountMapValue = teamCountMap.get(teamCountMapKey);

            if (!memberFirst.containsKey(teamCountMapKey)) {
                System.out.println(0);
                return;
            }

            int memberFirstValue = memberFirst.get(teamCountMapKey);
            long numerator = 1L;
            long denominator = 1L;
            for (int i = 0; i < teamCountMapValue; i++) {
                numerator *= (memberFirstValue - i);
                denominator *= (i + 1);
            }
            answerArr[index++] = (numerator / denominator);
        }

        long answer = answerArr[0];
        for (int i = 1; i < answerArr.length; i++) {
            answer *= answerArr[i];
        }
        br.close();

        System.out.println(answer);
    }
}
