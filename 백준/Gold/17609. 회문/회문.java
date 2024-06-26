import java.io.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        //O(N)이면 됨
        while(T-- > 0){
            String str = br.readLine();

            int answer = 2;

            //회문인가
            answer = isPalindrome(str, 0, str.length() - 1);
            //유사회문인가
            if(answer == 2){
                answer = isSimilarPalindrome(str);
            }

            result.append(answer + "\n");

            //둘 모두 해당되지 않는가
        }
        System.out.println(result);
    }

    private static int isSimilarPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            //처음 회문이 아닌 부분에서 xabba 0, 4 xabb = left , abba = right
            if(str.charAt(start) != str.charAt(end)){
                int left = isPalindrome(str, start, end-1);
                int right = isPalindrome(str, start + 1, end);

                if(left == 0 || right == 0){
                    return 1;
                }else{
                    return 2;
                }
            }
            start++;
            end--;
        }

        //미도달
        return -1;
    }

    public static int isPalindrome(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return 2;
            }
            start++;
            end--;
        }

        return 0;
    }
}
