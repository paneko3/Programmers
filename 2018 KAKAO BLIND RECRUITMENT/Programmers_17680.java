// Programmers_17680_2018 KAKAO BLIND RECRUITMENT_[1차] 캐시

import java.util.LinkedList;

public class Programmers_17680 {
    public static void main(String[] args){
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        Solution sol = new Solution();
        System.out.println(sol.solution(cacheSize, cities));
    }
    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            if(cacheSize==0){
                return cities.length*5;
            }
            int answer = 0;
            LinkedList<String> list = new LinkedList<>();
            for(String str : cities){
                str = new String(str.toLowerCase());
                if(list.remove(str)){
                    answer++;
                    list.add(str);
                }else {
                    answer+=5;
                    if(list.size()>=cacheSize){
                        list.remove(0);
                    }
                    list.add(str);
                }
            }
            return answer;
        }
    }
}

