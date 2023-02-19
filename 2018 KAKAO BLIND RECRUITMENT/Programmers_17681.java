// Programmers_17681_2018 KAKAO BLIND RECRUITMENT_[1차] 비밀지도

public class Programmers_17681 {
    public static void main(String[] args){
        int n =5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        Solution sol = new Solution();
        System.out.println(sol.solution(n, arr1, arr2));
    }
    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            boolean[][] map1 = new boolean[n][n];
            boolean[][] map2 = new boolean[n][n];
            for(int i=0;i<n;i++){
                int temp1 = arr1[i];
                int temp2 = arr2[i];
                for(int j=n-1;j>=0;j--){
                    if(temp1!=0){
                        if(temp1%2==1){
                            map1[i][j]=true;
                        }
                        temp1/=2;
                    }
                    if(temp2!=0){
                        if(temp2%2==1){
                            map2[i][j]=true;
                        }
                        temp2/=2;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                String str = "";
                for(int j=0;j<n;j++){
                    if(map1[i][j]||map2[i][j]){
                        str+="#";
                    }else {
                        str+=" ";
                    }
                }
                answer[i]=str;
            }
            return answer;
        }
    }
}

