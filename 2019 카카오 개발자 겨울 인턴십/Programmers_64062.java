// Programmers_64062_2019 카카오 개발자 겨울 인턴십_징검다리 건너기

public class Programmers_64062 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k =3;
        Solution sol = new Solution();
        System.out.println(sol.solution(stones,k));
    }
    static class Solution {
        public int solution(int[] stones, int k) {
            int answer =0;
            int min=1;
            int max = 200000000;
            while(min<=max){
                int mid = (min+max)/2;
                if(across(stones,k,mid)){
                    min=mid+1;
                    answer=Math.max(answer,mid);
                }else {
                    max=mid-1;
                }
            }
            return answer;
        }
        public boolean across(int[] stones,int k,int mid){
            int skip=0;
            for(int stone:stones){
                if(stone-mid<0){
                    skip++;
                }else {
                    skip=0;
                }
                if(skip==k){
                    return false;
                }
            }
            return true;
        }
    }
}
