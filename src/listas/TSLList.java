package listas;

/* Tachiri's Single Linked List
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */

public class TSLList <G> extends TLinkedList <G> {
    //Methods
    @Override
    public int lastIndexOf (G element) {                                                                           //Returns the last index of
        int index = -1;                                                                                            //the specified element
        TLLNode <G> current = first;

        for (int i = 0; i < size; i++) {
            if (current.getElement () == element) {
                index = i;
            }
            current = current.getNext ();
        }

        return index;
    }

    @Override
    public void add (G element) {                                                                                  //Adds the specified element at
        TLLNode <G> new_node = new TLLNode <> (element);                                                           //the end of the list

        if (size == 0) {
            first = last = new_node;
        } else {
            last.setNext (new_node);
            last = new_node;
        }

        size++;
    }

    @Override
    public void del () {                                                                                           //Deletes the last element
        if (size == 1) {                                                                                           //of the list
            eliminateFirst ();

            first = last = null;
        } else {
            TLLNode <G> current = first;

            for (int i = 1; i <= size; i++) {
                if (i == size - 1) {
                    last = current;
                    current.setNext (null);

                    size--;
                } else {
                    current = current.getNext ();
                }
            }
        }
    }

    @Override
    public void del (int pos) {                                                                                    //Deletes the element at the
        if (pos == 0) {                                                                                            //specified position
            eliminateFirst ();
        } else if (pos == size - 1) {
            del ();
        } else {
            TLLNode <G> current = first;

            for (int i = 1; i <= pos; i++) {
                if (i == pos) {
                    TLLNode <G> aux = current.getNext ();

                    current.setNext (current.getNext ().getNext () );
                    aux.setNext (null);

                    size--;
                } else {
                    current = current.getNext ();
                }
            }
        }
    }

    @Override
    public void insert (G element, int pos) {                                                                      //Inserts an element at the
        TLLNode <G> new_node = new TLLNode <> (element);                                                           //specified position

        if (pos == size) {
            add (element);
        } else if (pos == 0) {
            new_node.setNext (first);
            first = new_node;

            size++;
        } else {
            TLLNode <G> current = first;

            for (int i = 1; i < pos; i++) {
                current = current.getNext ();
            }

            new_node.setNext (current.getNext () );
            current.setNext (new_node);

            size++;
        }
    }

    @Override
    public void remove (G element) {                                                                               //Removes the specified element
        if (first.getElement () == element) {                                                                      //from the list
            eliminateFirst ();
        } else if (last.getElement () == element) {
            del ();
        } else {
            TLLNode <G> current = first;

            for (int i = 1; i < size; i++) {
                if (current.getNext ().getElement () == element) {
                    del (i);
                }
            }
        }
    }

    @Override
    public TSLList <G> sublist (int init_index, int end_index) {                                                   //Returns an IList sublist
        int new_size = end_index - init_index + 1;                                                                 //starting and ending at the
        TSLList <G> sublist = new TSLList <> ();                                                                   //specified position
        TLLNode <G> current  = first;

        for (int i = 0; i < init_index; i++) {
            current = current.getNext ();
        }

        for (int i = init_index; i < new_size; i++) {
            sublist.add (get (i) );

            current = current.getNext ();
        }

        return sublist;
    }


    //Auxiliary methods
    void eliminateFirst () {                                                                                       //Eliminates the first element
        TLLNode <G> aux = first;                                                                                   //of the list

        first = first.getNext ();
        aux.setNext (null);

        size--;
    }
}
