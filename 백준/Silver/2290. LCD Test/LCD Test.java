import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int s;
    static String[] n;
    static String[][] graph;

    static void oper() {

        for (int i = 0; i < n.length; i++) {
            int startWidth = i * (s + 2) + i;
            int endWidth = startWidth + s + 1;
            int endHeight = s * 2 + 2;
            String target = n[i];

            //뚜껑
            for (int temp = startWidth + 1; temp <= startWidth + s; temp++) {
                if (!target.equals("1") && !target.equals("4")) {
                    graph[0][temp] = "-";
                }
            }
            //1번째 세로
            for (int temp = 1; temp <= s; temp++) {
                if (target.equals("4") || target.equals("5")
                        || target.equals("6") || target.equals("8")
                        || target.equals("9") || target.equals("0")) {
                    graph[temp][startWidth] = "|";
                }
                if (target.equals("1") || target.equals("2") || target.equals("3") || target.equals("4") || target.equals("7") || target.equals("8") || target.equals("9") || target.equals("0")) {
                    graph[temp][endWidth] = "|";
                }
            }
            //중간뚜껑
            for (int temp = startWidth + 1; temp <= startWidth + s; temp++) {
                if (!target.equals("1") && !target.equals("7") && !target.equals("0")) {
                    graph[s + 1][temp] = "-";
                }
            }
            //2번째 세로
            for (int temp = s + 2; temp < s + 2 + s; temp++) {
                if (target.equals("2")
                        || target.equals("6")
                        || target.equals("8")
                        || target.equals("0")) {
                    graph[temp][startWidth] = "|";
                }

                if (target.equals("1")
                        || target.equals("3")
                        || target.equals("4")
                        || target.equals("5")
                        || target.equals("6")
                        || target.equals("7")
                        || target.equals("8")
                        || target.equals("9")
                        || target.equals("0")) {
                    graph[temp][endWidth] = "|";
                }
            }
            //마지막뚜껑
            for (int temp = startWidth + 1; temp <= startWidth + s; temp++) {
                if (!target.equals("1") && !target.equals("4") && !target.equals("7")) {
                    graph[endHeight][temp] = "-";
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        s = Integer.parseInt(strs[0]);
        n = strs[1].split("");

        int totalWidth = (s + 2) * n.length + (1 * n.length);
        int totalHeight = (2 * s) + 3;
        graph = new String[totalHeight][totalWidth];

        oper();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                sb.append(graph[i][j] == null ? " " : graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
