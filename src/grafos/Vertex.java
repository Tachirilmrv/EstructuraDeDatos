package grafos;

import java.util.List;

public class Vertex {
    //Attributes
    private final String name;
    private Vertex previous;
    private int scratch;
    private double dist;
    private List <Edge> adjacent;


    //Constructors
    public Vertex (String name) {
        this.name = name;
    }


    //Getters
    public String getName () {
        return name;
    }

    public Vertex getPrevious () {
        return previous;
    }

    public int getScratch () {
        return scratch;
    }

    public double getDist () {
        return dist;
    }

    public List <Edge> getAdjacent () {
        return adjacent;
    }


    //Setters
    public void setScratch (int scratch) {
        this.scratch = scratch;
    }

    public void setDist (double dist) {
        this.dist = dist;
    }

    public void setPrevious (Vertex previous) {
        this.previous = previous;
    }


    //Methods
    public void reset () {
        dist = Graph.INFINITY;
        previous = null;
        scratch = 0;
    }
}
