// Programmers_17683_2018 KAKAO BLIND RECRUITMENT_[3차] 방금그곡

public class Programmers_17683 {
    public static void main(String[] args){
        String m = "ABC";
        String[] musicinfos ={"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        Solution sol = new Solution();
        System.out.println(sol.solution(m, musicinfos));
    }
    static class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            int max = 0;
            for(String musicinfo : musicinfos){
                String[] info = musicinfo.split(",");
                int time = Integer.parseInt(info[1].substring(0,2))*60
                        -Integer.parseInt(info[0].substring(0,2))*60
                        +Integer.parseInt(info[1].substring(3,5))
                        -Integer.parseInt(info[0].substring(3,5));
                String melody = "";
                m = convert(m);
                info[3] = convert(info[3]);
                for(int i=0;i<time;i++){
                    melody+=info[3].charAt(i%info[3].length());
                }
                System.out.println(info[3]);
                System.out.println(melody);
                melody = convert(melody);
                if(melody.contains(m)){
                    if(melody.length()>max){
                        max=melody.length();
                        answer= info[2];
                    }
                }
            }
            if(answer==""){
                answer="(None)";
            }
            return answer;
        }
        static String convert(String str){
            str =str.replace("C#","c");
            str =str.replace("D#","d");
            str =str.replace("F#","f");
            str =str.replace("G#","g");
            str =str.replace("A#","a");
            return str;
        }
    }
}