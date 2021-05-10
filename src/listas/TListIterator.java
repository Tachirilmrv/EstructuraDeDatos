package listas;

import java.util.ListIterator;
import java.util.function.Consumer;

/** Tachiri's List Iterator interface
 *  @author Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */

public interface TListIterator <G> extends ListIterator <G> {
    //Constants
     int NATURAL_ORDER = 1;
     int REVERSE_ORDER = -1;

    @Override
    boolean hasNext ();                                                                                            //Returns whether there are
                                                                                                                   //next elements in the list
    @Override
    G next ();                                                                                                     //Returns a reference to the
                                                                                                                   //next element of the list
    @Override
    boolean hasPrevious ();                                                                                        //Returns whether there are
                                                                                                                   //previous elements in the list
    @Override
    G previous ();                                                                                                 //Returns a reference to the
                                                                                                                   //previous element of the list
    @Override
    int nextIndex ();                                                                                              //Returns a reference to the
                                                                                                                   //next index of the list
    @Override
    int previousIndex ();                                                                                          //Returns a reference to the
                                                                                                                   //previous index of the list
    @Override
    void forEachRemaining (Consumer <? super G> action);                                                           //Accepts an action for each
                                                                                                                   //remaining elements in the list
    @Override
    void remove ();                                                                                                //Remove the next or previous
                                                                                                                   //reference
    @Override
    void set (G g);                                                                                                //Set the next or previous
                                                                                                                   //reference
    @Override
    void add (G g);                                                                                                //Add the next or previous
                                                                                                                   //reference
}
