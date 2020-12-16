package BAEKJOON.BruteForce.Permutation;

public class perm_test {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        perm(arr, output, visited, 0, n);
        System.out.println();
     //   permutation(arr, 0, n);
    }

    // ���������� ���� ���ϱ�
    // ��� ����: perm(arr, output, visited, 0, n, 3);
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n) {
        if (depth == n) {
            print(output, n);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                 perm(arr, output, visited, depth + 1, n);
                visited[i] = false;
            }
        }
    }

    // ���� ���ϱ�
    // ��� ����: permutation(arr, 0, n, 4);
    static void permutation(int[] arr, int depth, int n) {
        if (depth == n) {
            print(arr, n);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // �迭 ���
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
