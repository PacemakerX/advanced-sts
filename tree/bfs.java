import java.util.*;

public class BFS {
    static List<List<Integer>> g;
    static boolean[] vis;
    static int[] dis;

    public static void bfs(int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        vis[sourceNode] = true;
        dis[sourceNode] = 0;
        q.add(sourceNode);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int v : g.get(node)) {
                if (!vis[v]) {
                    dis[v] = dis[node] + 1;
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            g.get(a).add(b);
            g.get(b).add(a); // Undirected graph
        }

        vis = new boolean[n + 1];
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        int sourceNode = 1;
        bfs(sourceNode);

        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dis[i] + " ");
        }
        System.out.println();
    }
}
