package arboles;

import java.util.Iterator;
import java.util.function.Consumer;


/* Tachiri's Binary Tree interface
 *  @Author: Tachiri (Lazaro Michel Reyes Valdes)
 *  Centro de estudios de Ingenieria de Sistemas (CEIS), Universidad Tecnologica de La Habana (CUJAE)
 *  lmreyesv@ceis.cujae.edu.cu // tachirirv@gmail.com */


public interface IBinaryTree <G extends Comparable <G> > {
    void insert (G element);                                                                                       //Inserts a new node in the
                                                                                                                   //sorted tree

    void preorder (TTNode <G> node, Consumer <? super G> action);                                                  //Iterates over the tree in
                                                                                                                   //preorder and apply action
                                                                                                                   //on the current node

    void inorder (TTNode <G> node, Consumer <? super G> action);                                                   //Iterates over the tree in
                                                                                                                   //inorder and apply action
                                                                                                                   //on the current node

    void postorder (TTNode <G> node, Consumer <? super G> action);                                                 //Iterates over the tree in
                                                                                                                   //postorder and apply action
                                                                                                                   //on the current node

    void reversePostorder (TTNode <G> node, Consumer <? super G> action);                                          //Iterates over the tree in
                                                                                                                   //postorder and apply action
                                                                                                                   //on the current node

    void levelorder (Consumer <? super  G> action);                                                                //Iterates over the tree in
                                                                                                                   //levelorder and apply action
                                                                                                                   //on the current node

    void del (G element);                                                                                          //Deletes the node containing
                                                                                                                   //the specified element

    Iterator <G> iterator ();                                                                                      //Returns an iterator over
                                                                                                                   //the sorted tree
}
