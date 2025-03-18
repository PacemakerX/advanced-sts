import java.util.*;

public class Main {
    static int n, m; // Number of nodes and edges
    static List<List<int[]>> graph;
    static long[] dist;
    static boolean[] vis;

    public static void dijkstra(int src) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, src});
        dist[src] = 0;

        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            int u = (int) node[1];

            if (vis[u]) continue;
            vis[u] = true;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new long[]{dist[v], v});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        vis = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            graph.get(x).add(new int[]{y, z});
            graph.get(y).add(new int[]{x, z});
        }

        int source = sc.nextInt();
        dijkstra(source);

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Long.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
