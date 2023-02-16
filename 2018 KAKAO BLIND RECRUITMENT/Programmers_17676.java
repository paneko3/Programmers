// Programmers_17676_2018 KAKAO BLIND RECRUITMENT_[1차] 추석 트래픽

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Programmers_17676 {
    public static void main(String[] args){
        String[] lines = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        Solution sol = new Solution();
        System.out.println(sol.solution(lines));
    }
    static class Traffic{
        int start, end;
        public Traffic(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static class Solution {
        public int solution(String[] lines) {
            int answer = 1;
            ArrayList<Traffic> list = new ArrayList<>();
            StringTokenizer st;
            for(String line : lines){
                st = new StringTokenizer(line);
                st.nextToken();
                String endTime = st.nextToken();
                String treatTime = st.nextToken();
                int end = (int)((Integer.parseInt(endTime.substring(0,2))*3600
                        + Integer.parseInt(endTime.substring(3,5))*60)*1000
                        + Double.parseDouble(endTime.substring(6,12))*1000);
                int time = (int)(Double.parseDouble(treatTime.substring(0,treatTime.length()-1))*1000);
                int start = end - time +1;
                list.add(new Traffic(start,end));
            }
            int cnt;
            for(int i=0;i<list.size();i++){
                cnt =1;
                for(int j = i +1;j<list.size();j++){
                    if(list.get(i).end + 1000 > list.get(j).start){
                        cnt++;
                    }
                    answer = Math.max(answer,cnt);
                }
            }
            return answer;
        }
    }
}

