package colas;

import listas.TListIterator;


/**
 * Tachiri's Queue interface
 * @author Tachiri (Lazaro Michel Reyes Valdes)
 * Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 * lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com
 **/


public interface IQueue <G> {
    boolean isEmpty ();                                                                                            //Returns true if the queue is
                                                                                                                   //empty

    int size ();                                                                                                   //Returns the size of the queue


    boolean contains (G element);                                                                                  //Returns whether the queue
                                                                                                                   //contains the element or not

    G peek ();                                                                                                     //Returns the first element
                                                                                                                   //and does not delete it

    G poll ();                                                                                                     //Returns the first element
                                                                                                                   //and deletes it

    void offer (G element);                                                                                        //Adds the specified element
                                                                                                                   //at the end of the queue

    int search (G element);                                                                                        //Returns the index of the
                                                                                                                   //specified element

    void clear ();                                                                                                 //Clears the queue


    TListIterator <G> iterator ();                                                                                 //Returns an iterator over
                                                                                                                   //the queue
}
