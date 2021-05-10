package colas;

import listas.TDLList;
import listas.TLLIterator;
import listas.TListIterator;

import java.util.function.Consumer;


/* Tachiri's Queue class
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TQueue <G> implements IQueue <G>, Iterable <G> {
    //Attributes
    private TDLList <G> list = new TDLList <> ();
    private  TQueue <G> a;


    //Methods
    @Override
    public boolean isEmpty () {                                                                                    //Returns true if the queue is
        return list.isEmpty ();                                                                                    //empty
    }

    @Override
    public int size () {                                                                                           //Returns the size of the queue
        return list.size ();
    }

    @Override
    public boolean contains (G element) {                                                                          //Returns whether the queue
        return list.contains (element);                                                                            //contains the element or not
    }

    @Override
    public G peek () {                                                                                             //Returns the first element
        return list.get (0);                                                                                       //and does not delete it
    }

    @Override
    public G poll () {                                                                                             //Returns the first element
        G aux = peek ();                                                                                           //and deletes it

        list.del (0);

        return aux;
    }

    @Override
    public void offer (G element) {                                                                                //Adds the specified element
        list.add (element);                                                                                        //at the end of the queue
    }

    @Override
    public int search (G element) {                                                                                //Returns the index of the
        return list.indexOf (element);                                                                             //specified element
    }

    @Override
    public void clear () {                                                                                         //Clears the queue
        list.clear ();
    }

    @Override
    public TListIterator <G> iterator () {                                                                         //Returns an iterator over
        return new TLLIterator <G> (list, TListIterator.NATURAL_ORDER);                                            //the queue
    }

    @Override
    public void forEach (Consumer <? super G> action) {
        iterator ().forEachRemaining (action);
    }
}
