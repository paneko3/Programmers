// Programmers_17686_2018 KAKAO BLIND RECRUITMENT_[3차] 파일명 정렬

import java.util.Arrays;

public class Programmers_17686 {
    public static void main(String[] args){
        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        Solution sol = new Solution();
        System.out.println(sol.solution(files));
    }
    static class File implements Comparable<File>{
        int index;
        String origin,head,number,tail;
        public File(int index, String origin, String head, String number, String tail) {
            this.index = index;
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public File(int index, String head, String number, String tail) {
            this.index = index;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        public int compareTo(File o){
            if(this.head.toUpperCase().equals(o.head.toUpperCase())){
                if(Integer.parseInt(this.number)==Integer.parseInt(o.number)){
                    return this.index - o.index;
                }else {
                    return Integer.parseInt(this.number) - Integer.parseInt(o.number);
                }
            }else {
                return this.head.toUpperCase().compareTo(o.head.toUpperCase());
            }
        }
    }
    static class Solution {
        public String[] solution(String[] files) {
            File[] array = new File[files.length];
            int index=0;
            for(String str : files){
                String head="";
                String number="";
                String tail="";
                boolean flag1=false;
                boolean flag2=false;
                for(char c : str.toCharArray()){
                    if(!flag1){
                        if(c>='0'&&c<='9'){
                            flag1=true;
                            number+=c;
                        }else {
                            head+=c;
                        }
                    }else {
                        if(!flag2){
                            if(c>='0'&&c<='9'){
                                number+=c;
                            }else {
                                flag2=true;
                                tail+=c;
                            }
                        }else {
                            tail+=c;
                        }
                    }
                }
                array[index]=new File(index++,str,head,number,tail);
            }
            Arrays.sort(array);
            String[] answer = new String[files.length];
            for(int i=0;i<files.length;i++){
                answer[i]=array[i].origin;
            }
            return answer;
        }
    }
}

