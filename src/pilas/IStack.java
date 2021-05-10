package pilas;

import listas.TListIterator;


/* Tachiri's Stack interface
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public interface IStack <G> {
    boolean isEmpty ();                                                                                            //Returns true if the stack is
                                                                                                                   //empty

    int size ();                                                                                                   //Returns the size of the stack


    boolean contains (G element);                                                                                  //Returns whether the element is
                                                                                                                   //in the stack or not

    G peek ();                                                                                                     //Returns the top element
                                                                                                                   //and does not delete it

    G pop ();                                                                                                      //Returns the last element
                                                                                                                   //and deletes it

    void push (G element);                                                                                         //Adds the specified element
                                                                                                                   //at the top of the stack

    int search (G element);                                                                                        //Returns the index of the
                                                                                                                   //specified element

    void clear ();                                                                                                 //Clears the stack


    TListIterator <G> iterator ();                                                                                 //Returns an iterator over
                                                                                                                   //the stack
}
