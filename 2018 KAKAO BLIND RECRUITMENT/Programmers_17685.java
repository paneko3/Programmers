// Programmers_17685_2018 KAKAO BLIND RECRUITMENT_[3차] 자동완성

import java.util.HashMap;
import java.util.Map;

public class Programmers_17685 {
    public static void main(String[] args){
        String[] words = {"go","gone","guild"};
        Solution sol = new Solution();
        System.out.println(sol.solution(words));
    }
    static class Node{
        Map<Character,Node> childNode= new HashMap<>();
        int maxDepth = 0;
        Node put(char c){
            maxDepth++;
            if(!childNode.containsKey(c)){
                childNode.put(c,new Node());
            }
            return childNode.get(c);
        }
    }
    static class Solution {
        public int solution(String[] words) {
            int answer = 0;
            Node rootNode = new Node();
            for(String str : words){
                Node node = rootNode;
                for(int i=0;i<str.length();i++){
                    Node newRoot = node.put(str.charAt(i));
                    node = newRoot;
                }
                node.put('-');
            }
            answer = cal(rootNode,0);

            return answer;
        }
    }
    static int cal(Node root,int depth){
        if(root.maxDepth ==1){
            return depth;
        }
        int count =0;
        for(char c : root.childNode.keySet()){
            if(c == '-'){
                count+=depth;
            }else {
                count += cal(root.childNode.get(c),depth+1);
            }
        }
        return count;
    }
}

