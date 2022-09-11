import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        int temp = 9;
        int result = 0;
        int numCnt = 1;
        while (true) {
            if(target > temp){
                result += numCnt * temp;
                target -= temp;
            }else{
                result += (target % temp) * numCnt;
                break;
            }
            temp *= 10;
            numCnt +=1;
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        }
    }

