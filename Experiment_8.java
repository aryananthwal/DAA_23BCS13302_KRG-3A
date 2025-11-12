import java.util.*;

public class Experiment_8 {

    static class Pair implements Comparable<Pair> {
        int vertex, weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // For priority queue to work as a min-heap based on weight
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }

    static void dijkstra(int V, List<List<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            int d = current.weight;

            if (d > dist[u])
                continue;

            for (Pair edge : adj.get(u)) {
                int v = edge.vertex;
                int w = edge.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // Remove this line for directed graph
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        dijkstra(V, adj, src);

        sc.close();
    }
}
