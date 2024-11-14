import java.util.*;

class Solution {

        public String[] solution(String[] files) {

            List<FileName> list = new ArrayList<>();
            for(int k = 0; k < files.length; k++){
                String file = files[k];
                //HEAD, NUMBER, TAIL 로 구분
                String head = "";
                String number = "";
                String tail = "";
                int index = 0;
                for(int i = 0; i < file.length(); i++){
                    char c = file.charAt(i);
                    if(Character.isDigit(c)){
                        index = i;
                        break;
                    }
                    head += c;
                }
                for(int i = index; i < file.length(); i++){
                    char c = file.charAt(i);
                    if(!Character.isDigit(c)){
                        index = i;
                        break;
                    }
                    number += c;
                }

                tail = file.substring(index);

                FileName f = new FileName(head,number,tail,k);
                list.add(f);
            }

            Collections.sort(list, new Comparator<FileName>(){
                @Override
                public int compare(FileName o1, FileName o2){
                    String head1 = o1.head.toLowerCase();
                    String head2 = o2.head.toLowerCase();
                    if(head1.equals(head2)){
                        int num1 = Integer.parseInt(o1.number);
                        int num2 = Integer.parseInt(o2.number);
                        return num1 - num2;
                    }
                    return head1.compareTo(head2);
                }
            });
            
            String[] answer = new String[files.length];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = files[list.get(i).index];
            }
            return answer;
        }

        static class FileName {
            String head;
            String number;
            String tail;
            int index;
            
            public FileName(String head, String number, String tail, int index){
                this.head = head;
                this.number = number;
                this.tail = tail;
                this.index = index;
            }
        }
}