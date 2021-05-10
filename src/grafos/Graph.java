package grafos;

import java.util.*;

public class Graph {
    //Attributes
    private Map <String, Vertex> vertexMap;

    public static final double INFINITY = Double.MAX_VALUE;


    //Constructor
    public Graph () {
        vertexMap = new HashMap <> ();
    }


    //Method
    public void addEdge (String sourceName, String destName, double weight) {
        Vertex v = getVertex (sourceName);
        Vertex w = getVertex (destName);

        v.getAdjacent ().add (new Edge (w, weight) );
    }

    public void printPath (String destName) {
       Vertex w = vertexMap.get (destName);

       if (w == null)
           throw new NoSuchElementException ();
       else if (w.getDist () == INFINITY)
           System.out.print (destName + " is unreachable");
       else {
           System.out.print ("(Cost is: " + w.getDist () + ") ");
           printPath (w);
           System.out.println ();
       }
    }

    public void unweighted (String startName) {
        Vertex start;
        Queue <Vertex> queue;

        clearAll ();

        start = vertexMap.get (startName);

        if (start == null)
            throw new NoSuchElementException ("Start vertex not found");

        queue = new LinkedList <Vertex> ();

        queue.add (start);
        start.setDist (0);

        while (!queue.isEmpty () ) {
            Vertex v = queue.remove ();

            for (Edge e : v.getAdjacent () ) {
                Vertex w = e.getDestination ();

                if (w.getDist () == INFINITY) {
                    w.setDist (v.getDist () + 1);
                    w.setPrevious (v);
                    queue.add (w);
                }
            }
        }
    }

    public void dijkstra (String startName) {
        int nodesSeen = 0;
        Vertex start =  vertexMap.get (startName);
        PriorityQueue <Path> pQueue = new PriorityQueue <> ();

        if (start == null)
            throw new NoSuchElementException ("Start vertex not found");

        clearAll ();
        pQueue.add (new Path (start, 0) );
        start.setDist (0);

        while (!pQueue.isEmpty () && nodesSeen < vertexMap.size () ) {
            Path vrec = pQueue.remove ();
            Vertex v = vrec.getDestination ();

            if (v.getScratch () != 0)
                continue;

            v.setScratch (1);
            nodesSeen++;

            for (Edge e : v.getAdjacent ()) {
                Vertex w = e.getDestination ();
                double costVW = e.getWeight ();

                if (costVW < 0)
                    throw new RuntimeException ("Graph has negative edges");

                if (w.getDist () > v.getDist () + costVW) {
                    w.setDist (v.getDist () + costVW);
                    w.setPrevious (v);
                    pQueue.add (new Path (w, w.getDist () ) );
                }
            }
        }
    }

    public void negative (String startName) {

    }

    public void acyclic (String startName) {
        int iterations;
        Vertex start = vertexMap.get (startName);
        Queue <Vertex> queue = new LinkedList <> ();
        Collection <Vertex> vertexSet = vertexMap.values ();

        if (start == null)
            throw new NoSuchElementException ("Start vertex not found");

        clearAll ();
        start.setDist (0);

        for (Vertex v : vertexSet) {
            for (Edge e : v.getAdjacent () ) {
                e.getDestination ().setScratch (e.getDestination ().getScratch () + 1);
            }
        }

        for (Vertex v : vertexSet) {
            if (v.getScratch () == 0)
                queue.add (v);
        }

        for (iterations = 0; !queue.isEmpty (); iterations++) {
            Vertex v = queue.remove ();

            for (Edge e : v.getAdjacent () ) {
                Vertex w = e.getDestination ();
                double costVW = e.getWeight ();

                if (w.getScratch () - 1 == 0)
                    queue.add (w);

                if (v.getDist () == INFINITY)
                    continue;

                if (w.getDist () > v.getDist () + costVW) {
                    w.setDist (v.getDist () + costVW);
                    w.setPrevious (v);
                }
            }
        }

        if (iterations != vertexMap.size () )
            throw new RuntimeException ("Graph has a cycle");
    }

    private Vertex getVertex (String vertexName) {
        Vertex v = vertexMap.get (vertexName);

        if (v == null) {
            v = new Vertex (vertexName);
            vertexMap.put (vertexName, v);
        }

        return v;
    }

    private void printPath (Vertex destination) {
        if (destination.getPrevious () != null) {
            printPath (destination.getPrevious () );
            System.out.print ("to");
        }

        System.out.print (destination.getName () );
    }

    private void clearAll () {
        for (Vertex v : vertexMap.values () ) {
            v.reset ();
        }
    }
}
