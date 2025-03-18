import java.util.*;

public class BellmanFord {

    private int n, m;
    private List<Edge> edges;
    private long[] dist;
    private int[] parent;

    // Class to represent an edge
    private static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // Constructor to initialize the graph
    public BellmanFord(int n, int m) {
        this.n = n;
        this.m = m;
        edges = new ArrayList<>();
        dist = new long[n + 1];
        parent = new int[n + 1];
    }

    // Add an edge to the graph
    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    // Bellman-Ford algorithm to detect negative cycle and calculate shortest paths
    public boolean bellmanFord(int source) {
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[source] = 0;

        // Relax all edges (n - 1) times
        for (int i = 1; i <= n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Long.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                    parent[edge.v] = edge.u;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (dist[edge.u] != Long.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                System.out.println("Negative weight cycle detected!");
                return false;
            }
        }
        return true;
    }

    // Print shortest path distances
    public void printDistances(int source) {
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Long.MAX_VALUE) {
                System.out.println(i + " : INF");
            } else {
                System.out.println(i + " : " + dist[i]);
            }
        }
    }

    // Print the path from source to a target node
    public void printPath(int target) {
        if (dist[target] == Long.MAX_VALUE) {
            System.out.println("No path to " + target);
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = target; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);

        System.out.println("Path to " + target + ": " + path);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes and edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Create BellmanFord object
        BellmanFord graph = new BellmanFord(n, m);

        // Input edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.addEdge(u, v, w);
        }

        // Input source node
        int source = sc.nextInt();

        // Run Bellman-Ford algorithm
        if (graph.bellmanFord(source)) {
            graph.printDistances(source);

            // Print path for each node from source
            for (int i = 1; i <= n; i++) {
                graph.printPath(i);
            }
        }

        sc.close();
    }
}
