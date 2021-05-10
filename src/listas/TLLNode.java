package listas;

/* Tachiri's Linked Lists' Node
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */

public class TLLNode <G> {
    //Attributes
    private G element;                                                                                             //Value of the node
    private TLLNode <G> next;                                                                                      //Reference to next node
    private TLLNode <G> prev;                                                                                      //Reference to previous node


    //Constructor
    public TLLNode (G element) {
        setElement (element);
    }


    //Getters
    public G getElement () {
        return element;
    }

    public TLLNode <G> getNext () {
        return next;
    }

    public TLLNode <G> getPrev () {
        return prev;
    }

    //Setters
    public void setElement (G element) {
        this.element = element;
    }

    public void setNext (TLLNode <G> next) {
        this.next = next;
    }

    public void setPrev (TLLNode <G> prev) {
        this.prev = prev;
    }
}
