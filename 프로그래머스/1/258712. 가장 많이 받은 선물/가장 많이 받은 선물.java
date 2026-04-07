import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        List<String> memberList = new ArrayList<>();
        for(String friend : friends){
            memberList.add(friend);
        }
        int[][] arr = new int[memberList.size()][memberList.size()];
        int[][] arrJ = new int[memberList.size()][3];
        for(String gift : gifts){
            String[] giftMem = gift.split(" ");
            arr[memberList.indexOf(giftMem[0])][memberList.indexOf(giftMem[1])] += 1;
            arrJ[memberList.indexOf(giftMem[0])][1] += 1;
            arrJ[memberList.indexOf(giftMem[1])][2] += 1;
        }
        
        int[] answer = new int[memberList.size()];
        for(int i=0;i<memberList.size();i++){
            for(int j=i+1; j<memberList.size(); j++){
                if(i==j) continue;
                int a = arr[i][j];
                int b = arr[j][i];
                if(a>b){
                    answer[i]+=1;
                }
                else if(a<b){
                    answer[j]+=1;
                }
                else{
                    int aJ = arrJ[i][1] - arrJ[i][2];
                    int bJ = arrJ[j][1] - arrJ[j][2];
                    if(aJ>bJ){
                        answer[i]+=1;
                    }
                    if(aJ<bJ){
                        answer[j]+=1;
                    }
                }
            }
        }
        int max = 0;
        for(int num : answer){
            max = Math.max(max,num);
        }
        return max;
    }
}

//행렬로 구현하고
//지수 도 구현하고
//이 두개로 비교하기
//두사람사이에 더많은 선물 준사람이 선물받음.
//기록이 없거나 같다면 지수로 높으면 받음.