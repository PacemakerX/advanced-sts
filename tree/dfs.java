simport java.util.*;

public class DFS {
    static int n, m;
    static List<List<Integer>> g;
    static boolean[] visited;
    static List<Integer> temp;

    public static void dfs(int node) {
        temp.add(node);
        visited[node] = true;

        for (int v : g.get(node)) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void check(int n) {
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            temp = new ArrayList<>();
            
            dfs(i);

            System.out.println("For " + i);
            for (int j = 1; j <= n; j++) {
                System.out.print((visited[j] ? 1 : 0) + " ");
            }
            System.out.println();
            
            for (int val : temp) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            g.get(a).add(b);  // Directed graph
        }

        check(n);
    }
}
