// Programmers_17684_2018 KAKAO BLIND RECRUITMENT_[3차] 압축

import java.util.*;

public class Programmers_17684 {
    public static void main(String[] args){
        String msg = "KAKAO";
        Solution sol = new Solution();
        System.out.println(sol.solution(msg));
    }
    static class Solution {
        public int[] solution(String msg) {

            ArrayList<Integer> list = new ArrayList<>();
            Map<String,Integer> map = new HashMap<>();
            int idx =1;
            for(int i=0;i<26;i++){
                String temp = "";
                temp+=(char)('A'+i);
                map.put(temp,idx++);
            }
            String w = "";
            w+=msg.charAt(0);
            boolean flag=false;
            for(int i=1;i<msg.length();i++){
                String c = new String(String.valueOf(msg.charAt(i)));
                String temp = w + c;
                if(map.containsKey(temp)){
                    w +=c;
                    continue;
                }else {
                    list.add(map.get(w));
                    map.put(temp,idx++);
                    w = new String();
                    w += c;
                }
            }
            list.add(map.get(w));
            int[] answer = new int[list.size()];
            for (int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}

