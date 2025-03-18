import java.util.*;

public class TopologicalSortDFS {

    private int n, m;
    private List<List<Integer>> g;
    private boolean[] visited;
    private Stack<Integer> topoStack;

    // Constructor to initialize graph and input values
    public TopologicalSortDFS(int n, int m) {
        this.n = n;
        this.m = m;
        g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        topoStack = new Stack<>();
    }

    // Add edges to the graph
    public void addEdge(int x, int y) {
        g.get(x).add(y);
    }

    // DFS to perform topological sort
    private void dfs(int node) {
        visited[node] = true;

        for (int v : g.get(node)) {
            if (!visited[v]) {
                dfs(v);
            }
        }

        // Push the node to stack after visiting all its neighbors
        topoStack.push(node);
    }

    // Perform topological sort using DFS
    public List<Integer> topologicalSort() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // Extract elements from stack to get the topological order
        List<Integer> topo = new ArrayList<>();
        while (!topoStack.isEmpty()) {
            topo.add(topoStack.pop());
        }

        return topo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes and edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Create TopologicalSortDFS object
        TopologicalSortDFS graph = new TopologicalSortDFS(n, m);

        // Input edges
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.addEdge(x, y);
        }

        // Get the topological order
        List<Integer> topoOrder = graph.topologicalSort();

        // Check if the topological order has all nodes
        if (topoOrder.size() != n) {
            System.out.println("There exists a cycle");
        } else {
            // Print the topological order
            for (int v : topoOrder) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
