package Graph;

import java.util.*;

/*
 * @author Tabetha Boushey
 * Date: 7/9/2013
 * CSCI232 Lab 3
 * Class: Graph
 */
public class Graph {
    private Vertex[] vertexList;
    private int[][] adjMatrix;

    public Graph(int[][] graph) {
        adjMatrix = graph.clone();
        vertexList = new Vertex[graph.length];

        //create all vertices and store in the list
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i] = new Vertex(i + 1);
        }

        for (int x = 0; x < graph[0].length; x++) {
            for (int y = 0; y < graph.length; y++) {
                int weight = graph[x][y];
                if (weight != 0) {
                    vertexList[x].addNeighbor(new Edge(vertexList[x], vertexList[y], weight));
                    vertexList[y].addNeighbor(new Edge(vertexList[y], vertexList[x], weight));
                }
            }
        }
    }

    public static Vertex getVertexWithSmallestDistance(Set<Vertex> q) {
        Vertex smallest = q.iterator().next();
        
        for (Vertex v : q) {
            if (v.getDistance() < smallest.getDistance()) {
                smallest = v;
            }
        }
        return smallest;
    }

    public void printGraph() {
        for (Vertex v : vertexList) {
            System.out.println(v.toString());
        }
    }

    public Vertex[] getVertexList() {
        return vertexList;
    }

    public Vertex getVertexAt(int position) {
        return vertexList[position];
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}
