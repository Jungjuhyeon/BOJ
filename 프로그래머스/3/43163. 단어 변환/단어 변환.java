import java.util.*;


class Node{
    String word;
    int count;
    Node(String word, int count){
        this.word = word;
        this.count = count;
    }
    
}
class Solution {
    static boolean[] v;
    public int solution(String begin, String target, String[] words) {
        v = new boolean[words.length];
        return bfs(begin,target,words);
    }
    
    public int bfs(String begin, String target, String[] words){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin,0));
                
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.word.equals(target))return cur.count;
            
            for(int i=0; i<words.length; i++){
                int match =0;
                for(int j=0; j<begin.length() ; j++){
                    if(cur.word.charAt(j) == words[i].charAt(j)) match++;
                }
                
                if(!v[i] && match == begin.length()-1){
                    q.add(new Node(words[i],cur.count+1));
                    v[i] =true;
                }
            }
        }
                return 0;
        
    }
}
                
