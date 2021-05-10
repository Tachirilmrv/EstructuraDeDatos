package listas;

import java.util.function.Consumer;

/* Tachiri's Linked Lists abstract class
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */

public abstract class TLinkedList <G> implements TList <G>, Iterable <G> {
    //Attributes
    protected int size = 0;                                                                                          //Physical and logical size
    protected TLLNode <G> first;                                                                                     //Reference to first node
    protected TLLNode <G> last;                                                                                      //Reference to last node


    //Common methods' implementation
    @Override
    public int size () {                                                                                           //Returns the size of the list
        return size;
    }

    @Override
    public G get (int pos) {                                                                                       //Returns the value of the
        TLLNode <G> current = first;                                                                               //element at the specified
        //position
        for (int i = 0; i < pos; i++) {
            current = current.getNext ();
        }

        return current.getElement ();
    }

    @Override
    public void set (G element, int pos) {                                                                         //Sets the specified element
        TLLNode <G> current = first;                                                                               //at the position

        for (int i = 0; i < pos; i++) {
            current = current.getNext ();
        }

        current.setElement (element);
    }

    @Override
    public boolean contains (G element) {                                                                          //Returns true if the element
        boolean found = false;                                                                                     //is contained in the list
        TLLNode <G> current = first;

        for (int i = 0; i < size && !found; i++) {
            if (current.getElement () == element) {
                found = true;
            } else {
                current = current.getNext ();
            }
        }

        return found;
    }

    @Override
    public int indexOf (G element) {                                                                               //Returns the index of the
        int index = -1;                                                                                            //specified element
        boolean found = false;
        TLLNode <G> current = first;

        for (int i = 0; i < size && !found; i++) {
            if (current.getElement () == element) {
                index = i;
                found = true;
            } else {
                try {
                    current = current.getNext ();
                } catch (NullPointerException ignored) {}
            }
        }

        return index;
    }

    @Override
    public void clear () {                                                                                         //Clears the list
        int init_size = size;

        for (int i = 0; i < init_size; i++) {
            eliminateFirst ();
        }

        last = null;
    }

    @Override
    public G [] toArray () {                                                                                       //Returns an array containing
        G [] array = (G[]) new Object [size];                                                                      //all elements of the list
        TLLNode <G> current = first;

        for (int i = 0; i < size; i++) {
            array [i] = current.getElement ();
            current = current.getNext ();
        }

        return array;
    }

    @Override
    public TListIterator <G> iterator () {
        return new TLLIterator <G> (this, TListIterator.NATURAL_ORDER);
    }

    @Override
    public void forEach (Consumer <? super G> action) {
        iterator ().forEachRemaining (action);
    }

    //Auxiliary abstract methods implemented in subclasses
    abstract void eliminateFirst ();                                                                               //Eliminates the first element
                                                                                                                   //of the list
}
