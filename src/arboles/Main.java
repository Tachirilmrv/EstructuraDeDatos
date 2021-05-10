package arboles;

import java.util.Random;
import java.util.function.Consumer;

public class Main {
    public static void main (String[] args) {
        Random random = new Random ();
        TBinaryTree <Integer> tree = new TBinaryTree <> (random.nextInt (100) );

        for (int i = 0; i < 10; i++) {
            int value = random.nextInt (100);

            System.out.print (value + " ");
            tree.insert (value);
        }

        System.out.println ();

        tree.reversePostorder (tree.getRoot (), System.out :: println);
        tree.levelorder (new Consumer <Integer> () {
            @Override
            public void accept (Integer integer) {
                System.out.print (integer + " " );
            }
        } );
    }
}
