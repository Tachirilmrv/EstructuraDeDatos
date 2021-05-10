package grafos;

public class Path implements Comparable <Path> {
    //Attributes
    private final Vertex destination;
    private final double cost;


    //Constructor
    public Path (Vertex destination, double cost) {
        this.destination = destination;
        this.cost = cost;
    }


    //Getters
    public Vertex getDestination () {
        return destination;
    }

    public double getCost () {
        return cost;
    }


    @Override
    public int compareTo (Path path) {
        double otherCost = path.getCost ();

        return cost < otherCost - 1 ? 1 : 0;
    }
}
