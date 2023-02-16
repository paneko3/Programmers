// Programmers_17677_2018 KAKAO BLIND RECRUITMENT_[1차] 뉴스 클러스터링

import java.util.HashMap;

public class Programmers_17677 {
    public static void main(String[] args){
        String str1 = "FRANCE";
        String str2 = "french";
        Solution sol = new Solution();
        System.out.println(sol.solution(str1, str2));
    }
    static class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            str1 = new String(str1.toUpperCase());
            str2 = new String(str2.toUpperCase());
            HashMap<String, Integer> mapA = new HashMap<>();
            HashMap<String, Integer> mapB = new HashMap<>();
            for(int i=0;i<str1.length()-1;i++){
                String temp = str1.substring(i,i+2);
                if(temp.charAt(0)<'A'||temp.charAt(0)>'Z'){
                    continue;
                }
                if(temp.charAt(1)<'A'||temp.charAt(1)>'Z'){
                    continue;
                }
                if(!mapA.containsKey(temp)){
                    mapA.put(temp,1);
                }else {
                    mapA.put(temp,mapA.get(temp)+1);
                }
            }
            for(int i=0;i<str2.length()-1;i++){
                String temp = str2.substring(i,i+2);
                if(temp.charAt(0)<'A'||temp.charAt(0)>'Z'){
                    continue;
                }
                if(temp.charAt(1)<'A'||temp.charAt(1)>'Z'){
                    continue;
                }
                if(!mapB.containsKey(temp)){
                    mapB.put(temp,1);
                }else {
                    mapB.put(temp,mapB.get(temp)+1);
                }
            }
            HashMap<String, Integer> mapMin = new HashMap<>();
            HashMap<String, Integer> mapMax = new HashMap<>();
            for(String str : mapA.keySet()){
                if(mapB.containsKey(str)){
                    if(!mapMin.containsKey(str)){
                        mapMin.put(str,mapA.get(str));
                    }else {
                        mapMin.put(str,Math.min(mapMin.get(str),mapA.get(str)));
                    }
                    if(!mapMax.containsKey(str)){
                        mapMax.put(str,mapA.get(str));
                    }else {
                        mapMax.put(str,Math.max(mapMax.get(str),mapA.get(str)));
                    }
                }else {
                    if(!mapMax.containsKey(str)){
                        mapMax.put(str,mapA.get(str));
                    }else {
                        mapMax.put(str,Math.max(mapMax.get(str),mapA.get(str)));
                    }
                }
            }
            for(String str : mapB.keySet()){
                if(mapA.containsKey(str)){
                    if(!mapMin.containsKey(str)){
                        mapMin.put(str,mapB.get(str));
                    }else {
                        mapMin.put(str,Math.min(mapMin.get(str),mapB.get(str)));
                    }
                    if(!mapMax.containsKey(str)){
                        mapMax.put(str,mapB.get(str));
                    }else {
                        mapMax.put(str,Math.max(mapMax.get(str),mapB.get(str)));
                    }
                }else {
                    if(!mapMax.containsKey(str)){
                        mapMax.put(str,mapB.get(str));
                    }else {
                        mapMax.put(str,Math.max(mapMax.get(str),mapB.get(str)));
                    }
                }
            }
            double count1 = 0;
            double count2 = 0;
            for(Integer temp : mapMin.values()){
                count1+=temp;
            }
            for(Integer temp : mapMax.values()){
                count2+=temp;
            }
            System.out.println(count1);
            System.out.println(count2);
            if(count2 == 0){
                answer = 65536;
            }else {
                answer = (int)((count1/count2)*65536);
            }
            return answer;
        }
    }
}

