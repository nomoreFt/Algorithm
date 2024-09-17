import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 각 코스에 대한 진입 차수(in-degree)를 저장할 배열
        int[] inDegree = new int[numCourses];
        // 그래프를 인접 리스트로 표현
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // 그래프 및 진입 차수 초기화
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            
            graph.putIfAbsent(preCourse, new ArrayList<>());
            graph.get(preCourse).add(course);
            inDegree[course]++;
        }
        
        // 진입 차수가 0인 코스를 큐에 넣음 (즉, 선행 조건이 없는 코스)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 큐를 이용한 위상 정렬 수행
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;
            
            // 현재 코스가 선행 조건이 되는 다른 코스들에 대해 처리
            if (graph.containsKey(current)) {
                for (int nextCourse : graph.get(current)) {
                    inDegree[nextCourse]--;
                    // 새로 진입 차수가 0이 된 코스를 큐에 추가
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }
        
        // 위상 정렬을 모두 완료했을 때, 모든 코스를 완료했는지 여부 반환
        return completedCourses == numCourses;
    }
}
