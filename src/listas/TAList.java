package listas;

import java.util.Arrays;
import java.util.function.Consumer;


/** Tachiri's Array List
*  @author Tachiri (Lazaro Michel Reyes Valdes) **/
/*  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
*  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TAList <G> implements TList <G>, Iterable <G> {
    //Attributes
    private G [] array;                                                                                            //Background Array
    private int size = 0;                                                                                          //Logical size


    //Constructors
    public TAList () {                                                                                             //Creates a new instance of the
        array = (G[]) new Object [16];                                                                             //list with default value of 16
    }

    public TAList (int f_size) {                                                                                   //Creates a new instance of the
        array = (G[]) new Object [f_size];                                                                         //list with size specified by user
    }


    //Methods
    @Override
    public int size () {                                                                                           //Returns the value of the
        return size;                                                                                               //array's logical size
    }

    @Override
    public G get (int pos) {                                                                                       //Returns the value of the element
        return array [pos];                                                                                        //at the specified position
    }

    @Override
    public void set (G element, int pos) {                                                                         //Sets the specified element at
        array [pos] = element;                                                                                     //the position
    }

    @Override
    public boolean contains (G element) {                                                                          //Returns true if the element
        boolean found = false;                                                                                     //is contained in the list

        for (int i = 0; i < size && !found; i++) {
            if (array[i] == element) {
                found = true;
            }
        }

        return found;
    }

    @Override
    public int indexOf (G element) {                                                                               //Returns the index of the
        int index = -1;                                                                                            //specified element
        boolean found = false;

        for (int i = 0; i < size && !found; i++) {
            if (array [i] == element) {
                index = i;
                found = true;
            }
        }

        return index;
    }

    @Override
    public int lastIndexOf (G element) {                                                                           //Returns the last index of
        int index = -1;                                                                                            //the specified element

        for (int i = 0; i < size; i++) {
            if (array [i] == element) {
                index = i;
            }
        }

        return index;
    }

    @Override
    public void clear () {                                                                                         //Clears the list
        for (int i = 0; i < size; i++) {
            array [i] = null;
        }

        size = 0;

        reduceIfPossible ();
    }

    @Override
    public void add (G element) {                                                                                  //Adds the specified element at
        try {                                                                                                      //the end of the list
            array [size] = element;

            size++;
        } catch  (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundException) {
            array = Arrays.copyOf (array, array.length * 2);

            add (element);
        }
    }

    @Override
    public void del () {                                                                                           //Deletes the last element
        array [--size] = null;                                                                                     //of the list

        reduceIfPossible ();
    }

    @Override
    public void del (int pos) {                                                                                    //Deletes the element at the
        for (; pos < size; pos++) {                                                                                //specified position
            array [pos] = array [pos + 1];
        }

        size--;

        reduceIfPossible ();
    }

    @Override
    public void insert (G element, int pos) {                                                                      //Inserts an element at the
        try {                                                                                                      //specified position
            if (size + 1 - pos >= 0)
                System.arraycopy (array, pos - 1, array, pos, size + 1 - pos);

            array [pos] = element;

            size++;
        } catch  (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundException) {
            array = Arrays.copyOf (array, array.length * 2);

            insert (element, pos);
        }
    }

    @Override
    public void remove (G element) {                                                                               //Removes the specified element
        int pos = -1;                                                                                              //from the list
        boolean found = false;

        for (int i = 0; i < size && !found; i++) {
            if (array [i] == element) {
                found = true;
                pos = i;

                size--;
            }
        }

        for (; pos < size && found; pos++) {
            array [pos] = array [pos + 1];
        }

        reduceIfPossible ();
    }

    @Override
    public TAList <G> sublist (int init_index, int end_index) {                                                     //Returns a sublist starting
        int new_size = end_index - init_index + 1;                                                                 //and ending at the specified
        TAList <G> sublist = new TAList <> (new_size);                                                              //positions

        for (int i = init_index; i <= new_size; i++) {
            sublist.add (array [i] );
        }

        return sublist;
    }

    @Override
    public G [] toArray () {                                                                                       //Returns an array containing
        return Arrays.copyOf (array, size);                                                                        //all elements of the list
    }


    //Auxiliary methods
    private void reduceIfPossible () {                                                                             //Reduces the array by half if it
        if (size <= (array.length / 4) ) {                                                                         //reached 1/4 of its size
            array = Arrays.copyOf (array, array.length / 2);
        }
    }


    //Not implemented yet
    @Override
    public TListIterator <G> iterator () {
        return new TALIterator <> (this, TListIterator.NATURAL_ORDER);
    }

    @Override
    public void forEach (Consumer <? super G> action) {
        iterator ().forEachRemaining (action);
    }
}
