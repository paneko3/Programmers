// Programmers_17682_2018 KAKAO BLIND RECRUITMENT_[1차] 다트 게임

import java.util.ArrayList;

public class Programmers_17682 {
    public static void main(String[] args){
        String dartResult = "1D#2S*3S";
        Solution sol = new Solution();
        System.out.println(sol.solution(dartResult));
    }
    static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int index = 0;
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<dartResult.length();i++){
                String str = "";
                if(dartResult.charAt(i)=='S'
                ||dartResult.charAt(i)=='D'
                ||dartResult.charAt(i)=='T'){
                    str = dartResult.substring(index,i+1);
                    index=i+1;
                    if(i+1<dartResult.length()){
                        if(dartResult.charAt(i+1)=='*'
                        ||dartResult.charAt(i+1)=='#'){
                            str +=dartResult.charAt(i+1);
                            index++;
                        }
                    }
                    list.add(str);
                }
            }
            int[] num = new int[3];
            for (int i =0;i<3;i++){
                String str = list.get(i);
                int score=0;
                char bonus='S';
                char option=' ';
                if(str.contains("S")){
                    score=Integer.parseInt(str.substring(0,str.indexOf("S")));
                    bonus='S';
                }else  if(str.contains("D")){
                    score=Integer.parseInt(str.substring(0,str.indexOf("D")));
                    bonus='D';
                }else  if(str.contains("T")){
                    score=Integer.parseInt(str.substring(0,str.indexOf("T")));
                    bonus='T';
                }
                if(score==10){
                    if(str.length()==4){
                        option=str.charAt(3);
                    }
                }else {
                    if(str.length()==3){
                        option=str.charAt(2);
                    }
                }
                if(bonus=='S'){
                    num[i]=score;
                }else if(bonus=='D'){
                    num[i]=score*score;
                }else if(bonus=='T'){
                    num[i]=score*score*score;
                }
                if(option=='*'){
                    num[i]*=2;
                    if(i!=0){
                        num[i-1]*=2;
                    }
                }else if(option=='#'){
                    num[i]*=-1;
                }
            }
            answer = num[0]+ num[1]+ num[2];
            return answer;
        }
    }
}

