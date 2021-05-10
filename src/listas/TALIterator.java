package listas;

import java.util.function.Consumer;


/* Tachiri's Array List Iterator
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TALIterator <G> implements TListIterator <G> {
    //Attributes
    private TAList <G> list;                                                                                       //TAList to provide iterator
    private int current;                                                                                           //Current index
    private int iteratorDirection;                                                                                 //Defines the order


    //Constructor
    public TALIterator (TAList <G> list, int iteratorDirection) {
        this.list = list;
        this.iteratorDirection = iteratorDirection;

        if (iteratorDirection == NATURAL_ORDER)
            current = -1;
        else if (iteratorDirection == REVERSE_ORDER)
            current = list.size ();
    }


    //Methods
    @Override
    public boolean hasNext () {
        return current < list.size ();
    }

    @Override
    public G next () {
        return list.get (++current);
    }

    @Override
    public boolean hasPrevious () {
        return current >= 0;
    }

    @Override
    public G previous () {
        return list.get (--current);
    }

    @Override
    public int nextIndex () {
        return current += 1;
    }

    @Override
    public int previousIndex () {
        return current -= 1;
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

    @Override
    public void remove () {                                                                                        //Removes the next or previous
        if (iteratorDirection == NATURAL_ORDER) {                                                                  //reference
            list.remove (next () );
        } else if (iteratorDirection == REVERSE_ORDER) {
            list.remove (previous () );
        }
    }

    @Override
    public void set (Object o) {                                                                                   //Sets the next or previous
        if (iteratorDirection == NATURAL_ORDER) {                                                                  //reference
            list.set (next (), nextIndex () );
        } else if (iteratorDirection == REVERSE_ORDER) {
            list.set (previous (), previousIndex () );
        }
    }

    @Override
    public void add (Object o) {                                                                                   //Adds the next or previous
        if (iteratorDirection == NATURAL_ORDER) {                                                                  //reference
            list.add (next () );
        } else if (iteratorDirection == REVERSE_ORDER) {
            list.add (previous () );
        }
    }
}
