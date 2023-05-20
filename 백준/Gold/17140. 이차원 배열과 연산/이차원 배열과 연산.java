import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[][] graph = new int[100][100];
    static int rowSize = 3;
    static int colSize = 3;
    static int r, c, k;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0])-1;
        c = Integer.parseInt(input[1])-1;
        k = Integer.parseInt(input[2]);

        for (int i = 0; i < 3; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        int time = 0;
        while(time <= 100){
            if(graph[r][c] == k) {
                System.out.println(time);
                System.exit(0);
            }
            if (rowSize >= colSize) {
                rCal();
            }else{
                cCal();
            }
            time++;
        }
        
        System.out.println(-1);
    }

    private static void cCal() {
        int nowRow = rowSize;
        int nowCol = colSize;
        for (int j = 0; j < nowCol; j++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nowRow; i++) {
                if (graph[i][j] != 0) {
                    if (map.containsKey(graph[i][j])) {
                        map.put(graph[i][j], map.get(graph[i][j])+1);
                    }else{
                        map.put(graph[i][j], 1);
                    }
                    graph[i][j] = 0;
                }
            }

            ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list,(o1,o2) -> {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                } else{
                    return o1.getValue() - o2.getValue();
                }
            });

            rowSize = Math.max(rowSize, list.size()*2);
            int idx = 0;

            for (Map.Entry<Integer, Integer> m : list) {
                if (idx < 100) {
                    graph[idx][j] = m.getKey();
                    idx += 1;
                    graph[idx][j] = m.getValue();
                    idx++;
                }
            }




        }

    }

    private static void rCal() {
        int nowRow = rowSize;
        int nowCol = colSize;
        for (int i = 0; i < nowRow; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < nowCol; j++) {
                if(graph[i][j] != 0) {
                    if (map.containsKey(graph[i][j])) {
                        map.put(graph[i][j], map.get(graph[i][j])+1);
                    }else{
                        map.put(graph[i][j], 1);
                    }
                    graph[i][j] = 0;
                }
            }

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
            Collections.sort(entryList, (o1, o2) -> {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }else{
                    return o1.getValue() - o2.getValue();
                }
            });


            colSize = Math.max(colSize,entryList.size()*2);

            int idx = 0;
            for (Map.Entry<Integer, Integer> m : entryList) {
                if (idx < 100) {
                    graph[i][idx] = m.getKey();
                    idx += 1;
                    graph[i][idx] = m.getValue();
                    idx++;
                }
            }

        }

    }
}

