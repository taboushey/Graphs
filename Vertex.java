package Graph;

import java.util.*;

/*
 * @author Tabetha Boushey
 * Date: 7/9/2013
 * CSCI232 Lab 3
 * Class: Vertex
 */

public class Vertex {
    private int id;
    private ArrayList<Edge> neighbors;
    private ArrayList<Edge> minNeighborList;
    private int distance;
    private Vertex previous;
    private boolean hasBeenVisited;

    public Vertex(int id) {
        this.id = id;
        distance = Integer.MAX_VALUE;
        previous = null;
        hasBeenVisited = false;
        neighbors = new ArrayList<>();
        minNeighborList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public boolean getHasBeenVisited() {
        return hasBeenVisited;
    }

    public void setHasBeenVisited(boolean visited) {
        hasBeenVisited = visited;
    }

    public void addNeighbor(Edge newNeighbor) {
        neighbors.add(newNeighbor);
    }

    public ArrayList<Edge> getNeighbors() {
        return neighbors;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int newDistance) {
        distance = newDistance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex v) {
        previous = v;
    }

    @Override
    public String toString() {
        return "[" + (char) (id + 64) + "]";
    }
}
