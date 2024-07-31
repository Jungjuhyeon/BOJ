class Solution {
    public int solution(int[] citations) {
        int max =0;
        int min =0;
        int answer =0;
        
        int length = citations.length;
        
        for(int i=1;i<=length;i++){
            for(int j=0;j<length;j++){
                int n = citations[j];
                if(n<=i){
                    min++;
                }
                if(n>=i){
                    max++;
                }
            }
            if(min<=i && max>=i){
                answer =i;
            }
            min = 0;
            max = 0;
        }
        return answer;
    }
}