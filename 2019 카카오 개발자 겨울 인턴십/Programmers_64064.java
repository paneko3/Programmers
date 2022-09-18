// Programmers_64064_2019 카카오 개발자 인턴십_불량 사용자

import java.util.*;

public class Programmers_64064 {
    public static void main(String[] args) {
        String[] user_id={"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id={"fr*d*", "abc1**"};
        Solution sol = new Solution();
        System.out.println(sol.solution(user_id,banned_id));
    }
    static class Solution {
        static Set<Set<String>> set;
        public int solution(String[] user_id, String[] banned_id) {
            int answer = 0;
            set= new HashSet<>();
            dfs(user_id,banned_id,new LinkedHashSet<>());
            answer=set.size();
            for(Set<String> el : set){
                for(String str: el){
                    System.out.print(str + " ");
                }
                System.out.println();
            }
            return answer;
        }
        public void dfs(String[] user_id, String[] banned_id,Set<String> temp){
            if(temp.size() == banned_id.length){
                if(isBannedUser(temp,banned_id)){
                    set.add(new HashSet<>(temp));
                }
                return;
            }
            for(String userid : user_id){
                if(!temp.contains(userid)){
                    temp.add(userid);
                    dfs(user_id,banned_id,temp);
                    temp.remove(userid);
                }
            }
        }

        public boolean isBannedUser(Set<String> temp, String[] banned_id){
            int i=0;
            for(String user: temp){
                if(!isSameUser(user, banned_id[i++])){
                    return false;
                }
            }
            return true;
        }
        public boolean isSameUser(String a, String b){
            if(a.length()!=b.length()){
                return false;
            }
            for(int i=0;i<a.length();i++){
                if(b.charAt(i)=='*'){
                    continue;
                }
                if(a.charAt(i)!=b.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }
}
