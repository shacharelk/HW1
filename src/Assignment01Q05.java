public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int n = m.length;
        int[] distances = new int[n];
        int[] visited = new int[n];
        int[] queue = new int[n];
        int head = 0;
        int tail = 0;
        queue[tail] = i;
        tail++;
        visited[i] = 1;
        while (head < tail) {
            int current = queue[head];
            head++;
            if (current == j) {
                return distances[current];
            }
            for (int k = 0; k < n; k++) {
                if (m[current][k] == 1 && visited[k] == 0) {
                    visited[k] = 1;
                    distances[k] = distances[current] + 1;
                    queue[tail] = k;
                    tail++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}