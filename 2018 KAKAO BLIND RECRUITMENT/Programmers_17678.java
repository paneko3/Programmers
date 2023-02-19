// Programmers_17678_2018 KAKAO BLIND RECRUITMENT_[1차] 셔틀버스

import java.util.ArrayList;
import java.util.Collections;

public class Programmers_17678 {
    public static void main(String[] args){
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        Solution sol = new Solution();
        System.out.println(sol.solution(n,t,m,timetable));
    }
    static class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            String answer = "";
            ArrayList<Integer> list = new ArrayList<>();
            for(String str : timetable){
                list.add(Integer.parseInt(str.substring(0,2))*60 + Integer.parseInt(str.substring(3,5)));
            }
            Collections.sort(list);
            int startTime = 540;
            int lastTime = 0;
            int idx =0;
            int count =0;
            for(int i=0;i<n;i++){
                count = 0;
                if(idx >= list.size()){
                    break;
                }
                while (count < m){
                    if(startTime >= list.get(idx)){
                        lastTime = list.get(idx);
                        idx++;
                        count++;
                        if(idx >= list.size()){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                startTime += t;
            }
            if(count < m){
                answer += (startTime-t)/60 >= 10 ? (startTime-t)/60 : "0" + (startTime-t)/60;
                answer += ":";
                answer += (startTime-t)%60 >= 10 ? (startTime-t)%60 : "0" + (startTime-t)%60;
            }else {
                answer += (lastTime-1)/60 >= 10 ? (lastTime-1)/60 : "0" + (lastTime-1)/60;
                answer += ":";
                answer += (lastTime-1)%60 >= 10 ? (lastTime-1)%60 : "0" + (lastTime-1)%60;
            }
            return answer;
        }
    }
}

