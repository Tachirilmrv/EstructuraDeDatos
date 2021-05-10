package grafos;

public class Edge {
    //Attributes
    private Vertex destination;
    private double weight;


    //Constructor
    public Edge (Vertex destination, double weight) {
        setDestination (destination);
        setWeight (weight);
    }


    //Getters
    public Vertex getDestination () {
        return destination;
    }

    public double getWeight () {
        return weight;
    }


    //Setters
    public void setDestination (Vertex destination) {
        this.destination = destination;
    }

    public void setWeight (double weight) {
        this.weight = weight;
    }
}
