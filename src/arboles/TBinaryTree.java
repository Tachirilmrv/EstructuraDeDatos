package arboles;

import colas.TQueue;

import java.util.Iterator;
import java.util.function.Consumer;


/** Tachiri's Binary Tree class
 *  @author Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TBinaryTree <G extends Comparable <G> > implements IBinaryTree <G>, Iterable <G> {
    //Attributes
    private final TTNode <G> root;                                                                                       //Root of the sorted tree


    //Constructor
    public TBinaryTree (G element) {
        root = new TTNode <> (element);
    }


    //Getters
    public TTNode <G> getRoot () {
        return root;
    }


    //Methods
    @Override
    public void insert (G element) {                                                                               //Inserts a new node in the
        root.insert (element);                                                                                     //sorted tree
    }

    @Override
    public void preorder (TTNode <G> node, Consumer <? super G> action) {
        if (node == null)
            return;

        action.accept (node.getElement () );
        preorder (node.getLeftChild (), action);
        preorder (node.getRightChild (), action);
    }

    @Override
    public void inorder (TTNode <G> node, Consumer <? super G> action) {
        if (node == null)
            return;

        inorder (node.getLeftChild (), action);
        action.accept (node.getElement () );
        inorder (node.getRightChild (), action);
    }

    @Override
    public void postorder (TTNode <G> node, Consumer <? super G> action) {
        if (node == null)
            return;

        postorder (node.getLeftChild (), action);
        postorder (node.getRightChild (), action);
        action.accept (node.getElement () );
    }

    @Override
    public void reversePostorder (TTNode <G> node, Consumer <? super G> action) {
        if (node == null)
            return;

        reversePostorder (node.getRightChild (), action);
        action.accept (node.getElement () );
        reversePostorder (node.getLeftChild (), action);
    }

    @Override
    public void levelorder (Consumer <? super  G> action) {
        TQueue <TTNode <G> > queue = new TQueue <> ();

        queue.offer (root);

        for (TTNode <G> node : queue) {
            action.accept (node.getElement () );

            if (node.getLeftChild () != null) {
                queue.offer (node.getLeftChild () );
            }
            if (node.getRightChild () != null) {
                queue.offer (node.getRightChild () );
            }
        }
    }

    //ToDo *Iterator needed*
    @Override
    public void del (G element) {
        
    }

    @Override
    public Iterator <G> iterator () {
        return new TTIterator <> (this, TTIterator.INORDER);
    }

    @Override
    public void forEach (Consumer <? super G> action) {
        iterator ().forEachRemaining (action);
    }
}
