package listas;


public class Main {
    public static void main (String[] args) {
        //singleLinked ();
    }

    public static void arrayList () {
        TList <Integer> arry = new TAList <> ();
        TAList <Integer> arryi;

        arry.add (1);
        arry.add (2);
        arry.add (3);
        arry.del ();
        arry.insert (9, 1);
        arry.insert (4, 4);
        arry.del (0);
        arry.remove (2);
        arry.set (5, 3);

        //arryi = arry.sublist (1, 2);

        System.out.println (arry.get (0) );
        System.out.println (arry.get (1) );
        System.out.println (arry.get (2) );
        System.out.println (arry.size () );
        System.out.println (arry.lastIndexOf (6) );
        System.out.println (arry.lastIndexOf (5) );
        System.out.println ( (arry.isEmpty ()? "Si":"No") );

        TListIterator <Integer> iter = arry.iterator ();
    }

    public static void singleLinked () {
        TSLList <Integer> sll = new TSLList <> ();
        TSLList <Integer> slli;

        sll.add (1);
        sll.add (2);
        sll.add (3);
        sll.del ();
        sll.insert (9, 1);
        sll.insert (4, 4);
        sll.del (0);
        sll.remove (2);
        sll.set (5, 3);

        slli = sll.sublist (1, 2);

        System.out.println (sll.get (0) );
        System.out.println (sll.get (1) );
        System.out.println (sll.get (2) );
        System.out.println (sll.size () );
        System.out.println (sll.lastIndexOf (6) );
        System.out.println (sll.lastIndexOf (5) );
        System.out.println ( (sll.isEmpty ()? "Si":"No") );
    }

    public static void doublyLinked () {
        TDLList <Integer> dll = new TDLList <> ();
        TDLList <Integer> dlli;

        dll.add (1);
        dll.add (2);
        dll.add (3);
        dll.del ();
        dll.insert (9, 1);
        dll.insert (4, 4);
        dll.del (0);
        dll.remove (2);
        dll.set (5, 3);

        dlli = dll.sublist (1, 2);

        System.out.println (dll.get (0) );
        System.out.println (dll.get (1) );
        System.out.println (dll.get (2) );
        System.out.println (dll.size () );
        System.out.println (dll.lastIndexOf (6) );
        System.out.println (dll.lastIndexOf (5) );
        System.out.println ( (dll.isEmpty ()? "Si":"No") );
    }
}

