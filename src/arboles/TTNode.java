package arboles;


/* Tachiri's Tree Node
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TTNode <G extends Comparable <G> > {
    //Attributes
    private G element;                                                                                             //Value of the node
    private TTNode <G> leftChild;                                                                                  //Reference to left child
    private TTNode <G> rightChild;                                                                                 //Reference to right child


    //Constructor
    public TTNode (G element) {
        setElement (element);
    }


    //Getters
    public G getElement () {
        return element;
    }

    public TTNode <G> getLeftChild () {
        return leftChild;
    }

    public TTNode <G> getRightChild () {
        return rightChild;
    }

    //Setters
    public void setElement (G element) {
        this.element = element;
    }

    public void setLeftChild (TTNode <G> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild (TTNode <G> rightChild) {
        this.rightChild = rightChild;
    }


    //Methods
    public void  insert (G insertElement) {                                                                        //Checks where to insert a new
        if (insertElement.compareTo (element) < 0) {                                                               //node in the sorted tree
            if (leftChild == null) {
                leftChild = new TTNode <> (insertElement);
            } else {
                leftChild.insert (insertElement);
            }
        } else if (insertElement.compareTo (element) > 0) {
            if (rightChild == null) {
                rightChild = new TTNode <> (insertElement);
            } else {
                rightChild.insert (insertElement);
            }
        } else {
            throw new IllegalArgumentException ();
        }
    }
}
