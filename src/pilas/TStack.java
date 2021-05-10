package pilas;

import listas.TDLList;
import listas.TLLIterator;
import listas.TListIterator;

import java.util.function.Consumer;


/* Tachiri's Stack class
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TStack <G> implements IStack <G>, Iterable <G> {
    //Attributes
    private TDLList <G> list = new TDLList <> ();


    //Methods
    @Override
    public boolean isEmpty () {                                                                                    //Returns true if the stack
        return list.isEmpty ();                                                                                    //is empty
    }

    @Override
    public int size () {                                                                                           //Returns the size of the stack
        return list.size ();
    }

    @Override
    public boolean contains (G element) {                                                                          //Returns whether the element is
        return list.contains (element);                                                                            //in the stack or not
    }

    @Override
    public G peek () {                                                                                             //Returns the top element
        return list.get (list.size () - 1);                                                                        //and does not delete it
    }

    @Override
    public G pop () {                                                                                              //Returns the last element
        G aux = peek ();                                                                                           //and deletes it

        list.del ();

        return aux;
    }

    @Override
    public void push (G element) {                                                                                 //Adds the specified element
        list.add (element);                                                                                        //at the top of the stack
    }

    @Override
    public int search (G element) {                                                                                //Returns the index of the
        return list.lastIndexOf (element);                                                                         //specified element
    }

    @Override
    public void clear () {                                                                                         //Clears the stack
        list.clear ();
    }

    @Override
    public TListIterator <G> iterator () {                                                                         //Returns an iterator over
        return new TLLIterator <G> (list, TListIterator.REVERSE_ORDER);                                            //the stack
    }

    @Override
    public void forEach (Consumer <? super G> action) {
        iterator ().forEachRemaining (action);
    }
}
