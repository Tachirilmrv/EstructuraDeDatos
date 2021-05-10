package arboles;
//TODO
import java.util.Iterator;
import java.util.function.Consumer;


/* Tachiri's Tree Iterator
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public class TTIterator <G extends Comparable <G> > implements Iterator <G> {
    //Attributes
    private TBinaryTree <G> tree;
    private int iteratorOrder;


    //Constants
    public static final int PREORDER = -1;
    public static final int INORDER = 0;
    public static final int POSTORDER = 1;


    //Constructor
    public TTIterator (TBinaryTree <G> tree, int iteratorOrder) {
        this.tree = tree;
        this.iteratorOrder = iteratorOrder;
    }


    //Methods
    @Override
    public void forEachRemaining (Consumer <? super G> action) {
        if (iteratorOrder == PREORDER) {
            tree.preorder (tree.getRoot (), action);
        } else if (iteratorOrder == INORDER) {
            tree.inorder (tree.getRoot (), action);
        } else if (iteratorOrder == POSTORDER) {
            tree.postorder (tree.getRoot (), action);
        }
    }


    /* Iterator's methods not to implement */
    @Override
    public boolean hasNext () {
        return false;
    }

    @Override
    public G next () {
        return null;
    }
}
