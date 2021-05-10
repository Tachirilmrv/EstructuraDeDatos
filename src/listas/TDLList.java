package listas;


/* Tachiri's Doubly Linked List
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TDLList <G> extends TLinkedList <G> {
    //Methods
    @Override
    public int lastIndexOf (G element) {                                                                           //Returns the last index of
        int index = -1;                                                                                            //the specified element
        boolean found = false;
        TLLNode <G> current = last;

        for (int i = size; i > 0 && !found; i--) {
            if (current.getElement () == element) {
                index = i - 1;
                found = true;
            } else {
                try {
                    current = current.getPrev ();
                } catch (NullPointerException ignored) {}
            }
        }

        return index;
    }

    @Override
    public void add (G element) {                                                                                  //Adds the specified element at
        TLLNode <G> new_node = new TLLNode <> (element);                                                           //the end of the list

        if (isEmpty () ) {
            first = last = new_node;
        } else {
            last.setNext (new_node);
            new_node.setPrev (last);

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
            last = last.getPrev ();

            last.getNext ().setPrev (null);
            last.setNext (null);

            size--;
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
                    current.getNext ().setPrev (current);

                    aux.setNext (null);
                    aux.setPrev (null);
                } else {
                    current= current.getNext ();
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
            first.setPrev (new_node);

            first = new_node;

            size++;
        } else {
            TLLNode <G> current = first;

            for (int i = 1; i < pos; i++) {
                current = current.getNext ();
            }

            new_node.setNext (current.getNext () );
            new_node.setPrev (current);

            current.getNext ().setPrev (new_node);
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
    public TDLList <G> sublist (int init_index, int end_index) {                                                   //Returns a sublist
        int new_size = end_index - init_index + 1;                                                                 //starting and ending at the
        TDLList <G> sublist = new TDLList <> ();                                                                   //specified position
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
        first = first.getNext ();                                                                                  //of the list

        first.getPrev ().setNext (null);
        first.setPrev (null);

        size--;
    }
}
