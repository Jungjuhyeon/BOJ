
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for(int i=0;i<N;i++){
            String[] words = br.readLine().split("\\\\");
            trie.insert(words);
        }
        trie.print(trie.root,0);
    }

    static class TrieNode{
        Map<String,TrieNode> child = new TreeMap<>();
    }
    static class Trie{
        TrieNode root = new TrieNode();
        public void insert(String[] words){
            TrieNode node = root;

            for(String s: words){
                node = node.child.computeIfAbsent(s,k->new TrieNode());
            }
        }
        public void print(TrieNode node,int depth){
            for(String s: node.child.keySet()) {
                for (int i = 0; i < depth; i++) {
                    System.out.print(" ");
                }
                System.out.println(s);
                print(node.child.get(s),depth+1);
            }
        }
    }


}
