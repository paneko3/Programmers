// Programmers_17687_2018 KAKAO BLIND RECRUITMENT_[3차] n진수 게임

public class Programmers_17687 {
    public static void main(String[] args){
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        Solution sol = new Solution();
        System.out.println(sol.solution(n,t,m,p));
    }
    static class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";
            StringBuilder sb = new StringBuilder();
            int index = 1;
            sb.append(0);
            while (sb.length()<m*t){
                String str = "";
                int temp = index++;
                while (temp!=0){
                    if(temp%n<10){
                        str = temp%n + str;
                    }else {
                        str = String.valueOf((char)(temp%n+55))+str;
                    }
                    temp/=n;
                }
                sb.append(str);
            }
            for(int i=p-1;i<m*(t-1)+p;i+=m){
                answer+=sb.charAt(i);
            }
            return answer;
        }
    }
}

