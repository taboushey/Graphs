package Graph;

import java.util.*;

/*
 * @author Tabetha Boushey
 * Date: 7/9/2013
 * CSCI232 Lab 3
 * Class: Algorithms
 */
public class Algorithms {

    public static void breadthFirstSearch(Graph g, int startNode) {
        System.out.println("\nBreadth-First Search starting at " + (char) (startNode + 65));
        LinkedList<Vertex> queue = new LinkedList<>(); // makes the queue
        queue.add(g.getVertexAt(startNode)); // adds the startNode to the queue
        g.getVertexAt(startNode).setHasBeenVisited(true); // marks as visited

        while (!queue.isEmpty()) {
            Vertex t = queue.removeFirst(); // removes from the front of the queue
            System.out.println("Visiting: " + t.toString());
            for (Edge e : t.getNeighbors()) {
                if (!e.getDest().getHasBeenVisited()) {
                    e.getDest().setHasBeenVisited(true); // marks as visited
                    queue.add(e.getDest()); // adds to the end of the queue
                }
            }
        }
    }

    public static void depthFirstSearch(Graph g, int startNode) {
        System.out.println("\nDepth-First Search starting at " + (char) (startNode + 65));
        Stack<Vertex> stack = new Stack<>(); // makes the stack
        stack.push(g.getVertexAt(startNode)); // pushes the startNode onto the stack
        g.getVertexAt(startNode).setHasBeenVisited(true); // marks as visited

        while (!stack.isEmpty()) {
            Vertex t = stack.pop(); // pops the top of the stack
            System.out.println("Visiting: " + t.toString());
            for (Edge e : t.getNeighbors()) {
                if (!e.getDest().getHasBeenVisited()) {
                    e.getDest().setHasBeenVisited(true); // marks as visited
                    stack.add(e.getDest()); // adds to the stack
                }
            }
        }
    }

    public static void dijkstra(Graph g, int startNode, int endNode) {
        System.out.println("\nDijkstra's Algorithm from " + (char) (startNode + 65) + " to " + (char) (endNode + 65));
        Vertex source = g.getVertexAt(startNode); // beginning equals source
        Vertex dest = g.getVertexAt(endNode); // end equals dest

        source.setDistance(0);
        Set<Vertex> q = new HashSet<>();
        for (Vertex v : g.getVertexList()) { // for each Vertex g.getVertexList at v
            q.add(v); // adds v
        }

        while (!q.isEmpty()) {
            Vertex u = Graph.getVertexWithSmallestDistance(q);
            q.remove(u); // removes u

            if (u.getDistance() == Integer.MAX_VALUE) {
                break;
            }

            for (Edge edge : u.getNeighbors()) {
                int alt = u.getDistance() + edge.getWeight();
                if (alt < edge.getDest().getDistance()) {
                    edge.getDest().setDistance(alt);
                    edge.getDest().setPrevious(u);
                    q.add(edge.getDest());
                }
            }
        }

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex u = dest;
        while (u.getPrevious() != null) {
            path.add(u);
            u = u.getPrevious();
        }
        path.add(source);
        Collections.reverse(path); // reverses the path from F to A, to A to F
        System.out.println("Shortest path from " + source.toString() + " to " + dest.toString());
        System.out.println(path);
    }

    public static void prims(Graph g, int startNode) {
        System.out.println("\nPrim's Algorithm");
        ArrayList<Edge> mst = new ArrayList<>();
        Vertex start = g.getVertexAt(startNode);
        Vertex current = g.getVertexAt(startNode);
        current.setDistance(0);

        while (!current.getHasBeenVisited()) {
            current.setHasBeenVisited(true); // marks as visited
            for (Edge edge : current.getNeighbors()) {

                if (edge.getDest().getDistance() > edge.getWeight() && !edge.getDest().getHasBeenVisited()) {
                    edge.getDest().setDistance(edge.getWeight()); // gets the destination and makes the distance between it the weight
                    mst.add(edge); // adds edge to the minimum spanning tree
                    break;
                }
            }

            current = start;
            int dist = Integer.MAX_VALUE;
            for (Vertex vertex : g.getVertexList()) {
                if (!vertex.getHasBeenVisited() && dist > vertex.getDistance()) {
                    dist = vertex.getDistance();
                    current = vertex;
                }
            }
        }

        System.out.println("Minimum Spanning Tree");
        System.out.println(mst);
    }

    public static void floydWarshall(Graph g) {
        System.out.println("\nFloyd-Warshall Algorithm");
        int[][] dist = g.getAdjMatrix().clone();

        //dist[x][y] gets the weight between x and y
        for (int x = 0; x < dist[0].length; x++) {
            for (int y = 0; y < dist.length; y++) {
                if (dist[x][y] == 0 && x != y) {
                    dist[x][y] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int x = 0; x < dist[0].length; x++) {
            for (int y = 0; y < dist.length; y++) {
                if (dist[x][y] == Integer.MAX_VALUE || dist[x][y] < 0) {
                    System.out.print("* ");
                } else {
                    System.out.print(dist[x][y] + " ");
                }
            }
            System.out.println();
        }
    }
}
