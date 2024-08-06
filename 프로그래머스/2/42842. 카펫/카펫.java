class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown+yellow;
        int a=0;
        int b=0;
        for(int i=3;i<sum;i++){
            int j = sum/i;
            if(i*j==sum &&i*2 + (j-2)*2 ==brown){
                a = i;
                b = j;
            }
        }
        int[] answer =new int[]{a,b};
        return answer;
        
    }
}

//1. sum = brown+yellow를 합한다.
//2. nxm을해서 sum이 나오는 걸 찾는다.
//3. n*2 + (m-2)*2를 해서 sum이 나오면 그게 답이다.

