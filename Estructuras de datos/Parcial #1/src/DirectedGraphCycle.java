import java.util.ArrayList;
import java.util.List;

public class DirectedGraphCycle {

    public static List<Integer> findDirectedCycle(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        List<Integer> cycle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, i, graph, visited, cycle)) {
                    return cycle;
                }
            }
        }

        return null;
    }

    private static boolean dfs(int start, int current, int[][] graph, boolean[] visited, List<Integer> cycle) {
        visited[current] = true;
        cycle.add(current);

        for (int i = 0; i < graph[current].length; i++) {
            if (graph[current][i] == 1) {
                if (!visited[i]) {
                    if (dfs(start, i, graph, visited, cycle)) {
                        return true;
                    }
                } else if (i == start && cycle.size() == graph.length) {
                    return true;
                }
            }
        }

        visited[current] = false;
        cycle.remove(cycle.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----------Luis David Mora----------");
        int[][] graph1 = {{0, 1, 0, 1, 0}, {1, 0, 1, 1, 1}, {0, 1, 0, 0, 1}, {1, 1, 0, 0, 0}, {0, 1, 1, 0, 0}};
        List<Integer> cycle1 = findDirectedCycle(graph1);
        System.out.println("Ciclo en el grafo 1: " + cycle1);

        int[][] graph2 = {{0, 1, 0, 1, 0}, {1, 0, 1, 1, 1}, {0, 1, 0, 0, 1}, {1, 1, 0, 0, 1}, {0, 1, 1, 1, 0}};
        List<Integer> cycle2 = findDirectedCycle(graph2);
        System.out.println("Ciclo en el grafo 2: " + cycle2);
    }
}