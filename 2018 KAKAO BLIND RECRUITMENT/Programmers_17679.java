// Programmers_17679_2018 KAKAO BLIND RECRUITMENT_[1차] 프렌즈4블록

import java.util.Stack;

public class Programmers_17679 {
    public static void main(String[] args){
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        Solution sol = new Solution();
        System.out.println(sol.solution(m,n,board));
    }
    static class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] map = new char[m][n];
            boolean[][] check = new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    map[i][j] = board[i].charAt(j);
                }
            }
            boolean flag;
            while (true){
                flag = false;
                check = new boolean[m][n];
                for(int i=0;i<m-1;i++){
                    for(int j=0;j<n-1;j++){
                        if(map[i][j]!='0'&&map[i][j]==map[i+1][j]&&map[i][j]==map[i][j+1]&&map[i][j]==map[i+1][j+1]){
                            check[i][j]=true;
                            check[i+1][j]=true;
                            check[i][j+1]=true;
                            check[i+1][j+1]=true;
                        }
                    }
                }
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        if(check[i][j]){
                            answer++;
                            map[i][j]='0';
                            flag=true;
                        }
                    }
                }
                for(int i=0;i<n;i++){
                    Stack<Character> stack = new Stack<>();
                    for(int j=0;j<m;j++){
                        if(map[j][i]!='0'){
                            stack.push(map[j][i]);
                        }
                    }
                    for(int j=m-1;j>=0;j--){
                        if(!stack.isEmpty()){
                            map[j][i]=stack.pop();
                        }else {
                            map[j][i]='0';
                        }
                    }
                }
                if(!flag){
                    break;
                }
            }
            return answer;
        }
    }
}

