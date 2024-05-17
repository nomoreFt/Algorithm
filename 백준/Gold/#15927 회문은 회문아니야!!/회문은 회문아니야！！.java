import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int len = N.length();
        int start = 0;
        int end = N.length() - 1;

        boolean same = true;
        for(int i = 0; i < len/2; i++){
            if(N.charAt(i) != N.charAt(len - 1 - i)){
                System.out.println(N.length());
                return;
            }else if(N.charAt(i) != N.charAt(i+1)){
                same = false;
            }
        }
        if(same){
            System.out.println(-1);
            return;
        }
        System.out.println(N.length() - 1);
    }
}