
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Map<String,Integer> countMap = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for(int i=0;i<N;i++){
            String str = br.readLine();
            countMap.put(str,countMap.getOrDefault(str,0)+1);
            trie.insert(str);
        }
        System.out.println(sb);
    }

    public static class TrieNode{
        Map<Character,TrieNode> child = new HashMap<>();
        boolean isEnd;
    }
    public static class Trie{

        TrieNode root = new TrieNode();

        public void insert(String word){
            TrieNode node = root;
            int idx =0;
            boolean able = true;
            for(char c : word.toCharArray()){
                idx++;
                if(node.child.get(c) == null && able){
                    String s = word.substring(0,idx);
                    sb.append(s).append("\n");
                    able = false;
                }
                node = node.child.computeIfAbsent(c,k-> new TrieNode());
            }

            if(able){
                if(countMap.get(word)>=2){
                    sb.append(word).append(countMap.get(word));
                }else{
                    sb.append(word);
                }
                sb.append("\n");
            }
            node.isEnd = true;
        }
    }
}
