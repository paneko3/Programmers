// Programmers_64065_2019 카카오 개발자 인턴십_튜플

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers_64065 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
    static class Solution {
        public int[] solution(String s) {
            String[] array = s.split("},");
            for(int i=0;i<array.length;i++){
                String str = array[i];
                str = str.replaceAll("\\{","");
                str = str.replaceAll("\\}","");
                array[i]=str;
            }
            Arrays.sort(array, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            ArrayList<Integer> list = new ArrayList<>();
            for(String str: array){
                String[] tuple = str.split(",");
                for(String element: tuple){
                    int temp = Integer.parseInt(element);
                    if(!list.contains(temp)){
                        list.add(temp);
                    }
                }
            }

            int[] answer = new int[list.size()];
            for(int i=0;i<list.size();i++){
                answer[i]=list.get(i);
            }
            return answer;
        }
    }
}
