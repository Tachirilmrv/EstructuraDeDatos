package listas;


/* Tachiri's Linked Lists Iterator
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


import jdk.jfr.consumer.RecordedEvent;

import javax.sound.sampled.ReverbType;
import java.util.function.Consumer;

public class TLLIterator <G> implements TListIterator <G> {
    //Attributes
    private TLinkedList <G> list;                                                                                  //TLinkedList to provide iterator
    private TLLNode <G> current = new TLLNode <> (null);                                                  //Current TLLNode
    private int iteratorDirection;                                                                                 //Defines the order


    //Constructor
    public TLLIterator (TLinkedList <G> list, int iteratorDirection) {
        this.list = list;
        this.iteratorDirection = iteratorDirection;

        if (iteratorDirection == NATURAL_ORDER)
            current.setNext (list.first);
        else if (iteratorDirection == REVERSE_ORDER)
            current.setPrev (list.last);
    }


    //Methods
    @Override
    public boolean hasNext () {
        return current.getNext () != null;
    }

    @Override
    public G next () {
        G aux = current.getNext ().getElement ();

        current = current.getNext ();

        return aux;
    }

    @Override
    public boolean hasPrevious () {
        return current.getPrev () != null;
    }

    @Override
    public G previous () {
        G aux = current.getPrev ().getElement ();

        current = current.getPrev ();

        return aux;
    }

    @Override
    public int nextIndex () {
        return list.indexOf (current.getNext ().getElement () );
        //TODO Might be an error for duplicate values
    }

    @Override
    public int previousIndex () {
        return list.indexOf (current.getPrev ().getElement () );
        //TODO Might be an error for duplicate values
    }

    @Override
    public void forEachRemaining (Consumer <? super G> action) {
        if (iteratorDirection == NATURAL_ORDER) {
            while (hasNext () ) {
                action.accept (next () );
            }
        } else if (iteratorDirection == REVERSE_ORDER) {
            while (hasPrevious () ) {
                action.accept (previous () );
            }
        }
    }


    /* ListIterator's methods not to implement */
    @Override
    public void remove () {                                                                                        //Removes the next or previous
        if (iteratorDirection == NATURAL_ORDER) {                                                                  //reference
            list.remove (next () );
        } else if (iteratorDirection == REVERSE_ORDER) {
            list.remove (previous () );
        }
    }

    @Override
    public void set (G g) {                                                                                        //Sets the next or previous
        if (iteratorDirection == NATURAL_ORDER) {                                                                  //reference
            list.set (next (), nextIndex () );
        } else  if (iteratorDirection == REVERSE_ORDER) {
            list.set (previous (), previousIndex () );
        }
    }

    @Override
    public void add (G g) {                                                                                        //Adds the next or precious
        if (iteratorDirection == NATURAL_ORDER) {                                                                  //reference
            list.add (next () );
        } else  if (iteratorDirection == REVERSE_ORDER) {
            list.add (previous () );
        }
    }
}
