import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong)
                .sum();

        System.out.println(sum);
    }}