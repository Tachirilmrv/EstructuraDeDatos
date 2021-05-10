package listas;

/* Tachiri's List interface
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */

public interface TList <G> {
    int size ();                                                                                                   //Returns the logical size of the
                                                                                                                   // list

    G get (int pos);                                                                                               //Returns the value of the element
                                                                                                                   //at the specified

    void set (G element, int pos);                                                                                 //Sets the specified element at
                                                                                                                   //the position

    default boolean isEmpty () {                                                                                   //Returns true if the size of
        return size () == 0;                                                                                       //the list is equal to zero
    }

    boolean contains (G element);                                                                                  //Returns true if the element
                                                                                                                   //is contained in the list

    int indexOf (G element);                                                                                       //Returns the index of the
                                                                                                                   //specified element

    int lastIndexOf (G element);                                                                                   //Returns the last index of
                                                                                                                   //the specified element

    void clear ();                                                                                                 //Clears the list


    void add (G element);                                                                                          //Adds the element to the end of
                                                                                                                   //the list

    void del ();                                                                                                   //Deletes the last element of the
                                                                                                                   //list

    void del (int pos);                                                                                            //Deletes the element located at
                                                                                                                   //the specified position

    void insert (G element, int pos);                                                                              //Inserts the element at the
                                                                                                                   //specified position

    void remove (G element);                                                                                       //Removes the specified element
                                                                                                                   //from the list

    TList <G> sublist (int init_index, int end_index);                                                             //Returns a sublist starting
                                                                                                                   //and ending at the specified
                                                                                                                   //positions

    G [] toArray ();                                                                                               //Returns an array containing
                                                                                                                   //all elements of the list

    TListIterator <G> iterator ();                                                                                 //Returns an iterator over
                                                                                                                   //the list
}
