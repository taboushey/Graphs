package Graph;

/*
 * @author Tabetha Boushey
 * Date: 7/9/2013
 * CSCI232 Lab 3
 * Class: Edge
 */

public class Edge {
    private Vertex source;
    private Vertex dest;
    private int weight;

    public Edge(Vertex source, Vertex dest) {
        this.source = source;
        this.dest = dest;
    }

    public Edge(Vertex source, Vertex dest, int weight) {
        this(source, dest);
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDest() {
        return dest;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + source + " -> " + dest + ": " + weight + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Edge that = (Edge) obj;
            return getSource().getId() == that.getSource().getId() &&
                    getDest().getId() == that.getDest().getId() &&
                    getWeight() == that.getWeight();
        }
        return false;
    }
}
